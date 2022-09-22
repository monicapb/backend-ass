/**
 * 
 */
package com.aelion.suivi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.suivi.entities.PoeEntity;
import com.aelion.suivi.services.PoeService;

/**
 * @author jean-luc
 *
 */
@RestController
@RequestMapping("/poe")
public class POEController {
	
	@Autowired
	private PoeService service;
	
	@GetMapping()
	@CrossOrigin
	public List<PoeEntity> findAdll() {
		return this.service.findAll();
	}
	/**
	 * On est en structure Resfull où l'interet de faire une responseEntity pour recuperer une reponse http pour recuperer une poe
	 * et recuperer un 404 s'il la trouve pas 
	 * @param id
	 * @return
	 */
	
	@GetMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<?> findOne(@PathVariable int id) {
		try {
            return ResponseEntity.ok(this.service.getOne((long) id));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            ResponseEntity<Object> response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
            return response;
        }
	}
	

	@PostMapping()
	@CrossOrigin
	public PoeEntity add(@RequestBody PoeEntity poe) {
		return this.service.add(poe);
	}
	
	@PutMapping()
	@CrossOrigin
	public ResponseEntity<Object> update(@RequestBody PoeEntity poe) {
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<?> delete(@PathVariable int id) {
		try {
            this.service.deleteById((int)id);
            return ResponseEntity.noContent().build();
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<Object>("Id was not provided", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
	}
	
	
}
