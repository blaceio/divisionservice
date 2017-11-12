package io.blace.microservices.divisionservice.http;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.blace.microservices.divisionservice.mongo.division.Division;
import io.blace.microservices.divisionservice.mongo.division.DivisionRepository;

@RestController
public class DivisionRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DivisionRepository divisionrepo;
	
    @CrossOrigin
    @RequestMapping(value = "division")
    public ResponseEntity<List<Division>> getalldivisions() {
    		logger.info("getalldivisions requested");
        return new ResponseEntity<List<Division>>(divisionrepo.findAll(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @RequestMapping(value = "division", params = {"id"})
    public ResponseEntity<Division> getbyid(@RequestParam("id") String id){
    		logger.info("getbyid requested for " +  id);
        return new ResponseEntity<Division>(divisionrepo.findById(id), HttpStatus.OK);
    }   
    
    @CrossOrigin
    @PostMapping("/division")
    public ResponseEntity<Division> createdivision(@RequestBody Division division) {
    		logger.info("createdivision requested for " +  division.toString());
    		divisionrepo.save(division);
        return new ResponseEntity<Division>(HttpStatus.CREATED);
    }
    
    @CrossOrigin
    @PostMapping("/divisions")
    public ResponseEntity<Division> createdivisions(@RequestBody List<Division> divisions) {
    		logger.info("createdivisions requested");
    		
    		for( Division division : divisions) {
    			divisionrepo.save(division);
    		}
    		
        return new ResponseEntity<Division>(HttpStatus.CREATED);
    }
    
    @CrossOrigin
    @DeleteMapping(value = "/division")
    public ResponseEntity<Division> deletedivision(@RequestParam("deleteid") String deleteid) {
		logger.info("deletedivision requested for " +  deleteid);
    		Division division = divisionrepo.findById(deleteid);
    		divisionrepo.delete(division);
    		return new ResponseEntity<Division>(HttpStatus.ACCEPTED);
    }
	
}
