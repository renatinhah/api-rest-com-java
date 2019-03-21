package br.com.dito.desafio.renata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.dito.desafio.renata.entity.CustomData;
import br.com.dito.desafio.renata.entity.Evento;
import br.com.dito.desafio.renata.entity.Products;
import br.com.dito.desafio.renata.entity.Timeline;
import br.com.dito.desafio.renata.enuns.EventoEnum;
import br.com.dito.desafio.renata.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;

	public int findTimelineByTransactionId(ArrayList<Timeline> timelines, String transaction) {
		for(int i = 0; i < timelines.size(); i++) {
			if(timelines.get(i).getTransactionId().equals(transaction)) return i;
		}
		return -1;
	}
	
	public ArrayList<Timeline> addProductsTimeline(HashSet<String> transactions, ArrayList<Timeline> timelines) {
		ArrayList<Evento> eventos = eventoRepository.findByEventAndCustomData_keyAndCustomData_valueIn(EventoEnum.EVENTO_COMPROU_PRODUTO.getEvent(), EventoEnum.TRANSACTION_ID.getEvent(), transactions);
		int index;
		for(Evento e : eventos) {
			index = -1;
			Products product = new Products();
			ArrayList<CustomData> customData = e.getCustomData();
			for(CustomData c : customData) {
				if(c.getKey().equals(EventoEnum.PRODUCT_NAME.getEvent())) {
					product.setName(c.getValue());
				} else if (c.getKey().equals(EventoEnum.PRODUCT_PRICE.getEvent())) {
					product.setPrice(Double.parseDouble(c.getValue()));
				} else {
					index = this.findTimelineByTransactionId(timelines, c.getValue());
				}
			}
			if (index >= 0) {
				timelines.get(index).getProducts().add(product);
			}
		}
		return timelines;
	}
	
	public ArrayList<Timeline> createTimelineWithDataEventoComprou(ArrayList<Evento> eventos) {
		HashSet<String> transations = new HashSet<>();
		ArrayList<Timeline> timelines = new ArrayList<Timeline>();
		
		for(Evento e : eventos) {
			Timeline timeline = new Timeline();
			timeline.setTimestamp(e.getTimestamp());
			timeline.setRevenue(e.getRevenue());
			timeline.setProducts(new ArrayList<Products>());
			ArrayList<CustomData> customData = e.getCustomData();
			
			for(CustomData c : customData) {
				if(c.getKey().equals(EventoEnum.TRANSACTION_ID.getEvent())) {
					transations.add(c.getValue());
					timeline.setTransactionId(c.getValue());
				} else if (c.getKey().equals(EventoEnum.STORE_NAME.getEvent())) {
					timeline.setStoreName(c.getValue());
				}
			}
			timelines.add(timeline);
		}
		
		return this.addProductsTimeline(transations, timelines);
	}
	
	
	public HashMap<String, ArrayList<Timeline>> getAllEventos() {
		ArrayList<Evento> eventosComprou = eventoRepository.findByEvent(EventoEnum.EVENTO_COMPROU.getEvent(), new Sort(Sort.Direction.DESC,EventoEnum.TIMESTAMP.getEvent()));
		HashMap<String, ArrayList<Timeline>> timelineHashMap = new HashMap<>();
		timelineHashMap.put("timeline", this.createTimelineWithDataEventoComprou(eventosComprou));
		return timelineHashMap;
	}
	
	public void getEventoById(String id) {
		eventoRepository.findById(id);
	}
	
	public void getEventoByEvent(String event) {
		
	}
	
	public void create(Evento evento) {

	}

	public void delete(ObjectId _id) {

	}
}
