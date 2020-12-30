package com.afigueredo.api.repositories;

import java.util.List;

import com.afigueredo.api.documents.Cliente;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
  Cliente findByNome(String nome);

  @Query("{ 'idade' : { $gt: ?0, $lt: ?1 } }")
  List<Cliente> findByIdadeBetween(int idadeIncial, int indadeFinal);
}
