package br.com.dito.desafio.renata.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dito.desafio.renata.entity.Evento;
import br.com.dito.desafio.renata.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public void getAllEventos() {
		eventoRepository.findAll();
	}
	
	public void getEventoById(ObjectId _id) {
		eventoRepository.findBy_id(_id).getEvent();
	}
	
	public void create(Evento evento) {

	}

	public void delete(ObjectId _id) {

	}
}
