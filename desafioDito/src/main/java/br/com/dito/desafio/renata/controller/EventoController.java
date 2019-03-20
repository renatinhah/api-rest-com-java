package br.com.dito.desafio.renata.controller;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dito.desafio.renata.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void getAllEventos() {
		eventoService.getAllEventos();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void getEventoById(@PathVariable("id") ObjectId id) {
		eventoService.getEventoById(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void create(@Valid @RequestBody String teste) {

	}
	  
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {

	}
	
	
}
