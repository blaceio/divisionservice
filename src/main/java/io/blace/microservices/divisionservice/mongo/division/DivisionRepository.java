package io.blace.microservices.divisionservice.mongo.division;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DivisionRepository extends MongoRepository<Division, String> {

	Division findById(String id);
	
	List<Division> findAll();
	
}
