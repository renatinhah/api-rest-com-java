package br.com.dito.desafio.renata.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.dito.desafio.renata.entity.Evento;

@Repository
public interface EventoRepository extends MongoRepository<Evento, String> {
	Optional<Evento> findById(String id);
	ArrayList<Evento> findByEvent(String event, Sort sort);
	ArrayList<Evento> findByCustomData_keyAndCustomData_value(String key, String value);
	ArrayList<Evento> findByEventAndCustomData_keyAndCustomData_valueIn(String event, String key, HashSet<String> values);
	
}
