/**
 * 
 */
package com.aelion.suivi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.services.InternService;

/**
 * @author jean-luc
 *
 */
@RestController
@RequestMapping("/intern")
public class InternController {
	
	@Autowired
	private InternService internService;
	
	@GetMapping("/hello")
	public ResponseEntity<String> greetings() {
		return ResponseEntity.ok("Hello SpringBoot");
	}

	@GetMapping()
	@CrossOrigin
	public List<InternEntity> getAll()  {
	return this.internService.findAll();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<?>getOne(@PathVariable Long id) {
		Optional<InternEntity> oInternEntity = this.internService.findOne(id);
		if (oInternEntity.isPresent()) {
			return ResponseEntity.ok(oInternEntity.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * 
	 * @param intern
	 * @return 201 http-status
	 */
	
	@PostMapping()
	@CrossOrigin()
	public InternEntity add(@RequestBody InternEntity intern) {
		return this.internService.add(intern);
		
	}
	
	@DeleteMapping()
	@CrossOrigin
	public ResponseEntity<Object> delete(@RequestBody InternEntity intern) {
		this.internService.delete(intern);
		return ResponseEntity.noContent().build();
	}
}
