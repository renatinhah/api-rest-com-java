package br.com.dito.desafio.renata.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dito.desafio.renata.entity.Evento;
import br.com.dito.desafio.renata.entity.Timeline;
import br.com.dito.desafio.renata.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HashMap<String, ArrayList<Timeline>> getAllEventos() {
		return eventoService.getAllEventos();
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ArrayList<Evento> getEventoById(@PathVariable("name") String name) {
		return eventoService.getEventoByEvent(name);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void create(@Valid @RequestBody Evento evento) {
		eventoService.create(evento);
	}
	  
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {

	}
	
	
}
