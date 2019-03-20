package br.com.dito.desafio.renata.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.dito.desafio.renata.entity.Evento;

@Repository
public interface EventoRepository extends MongoRepository<Evento, String> {
	Evento findBy_id(ObjectId _id);
}
