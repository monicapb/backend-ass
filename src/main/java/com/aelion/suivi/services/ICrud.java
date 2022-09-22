/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

/**
 * @author jean-luc
 *
 */
public interface ICrud<T> {
	
	public T add(T item);
	public T[] add(T[] items);
	public void update(T item);
	public void delete(T item);
	public List<T> findAll();
	public Optional<T> findOne(Long id);
	
}
