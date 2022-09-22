/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.repositories.InternRepository;

/**
 * @author jean-luc
 *
 */
@Service
public class InternService implements ICrud<InternEntity> {
	
	@Autowired
	private InternRepository repository;
	
	
	/**
	 * INSERT INTO intern (name, firstName, ...) VALUES (...).
	 */
	@Override
	public InternEntity add(InternEntity item) {
		
		return this.repository.save(item);
	}

	@Override
	public InternEntity[] add(InternEntity[] items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(InternEntity item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(InternEntity item) {
		this.repository.delete(item);
		
	}

	@Override
	public List<InternEntity> findAll() {
		return (List<InternEntity>) this.repository.findAll();
	}

	@Override   
	public Optional<InternEntity> findOne(Long id) {
		return this.repository.findById(id);
	}

}
