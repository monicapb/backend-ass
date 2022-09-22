/**
 * 
 */
package com.aelion.suivi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author jean-luc
 *
 */
@Entity
@Table(name= "poe_type")
public class PoeTypeEntity {
	@Id // CLÉ PRIMARY 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT POUR MON ID
	private int id;
	@Column(length = 50) 
	private String title;
	@OneToMany()
	private List<PoeEntity> poes = new ArrayList<>();
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the poes
	 */
	public List<PoeEntity> getPoes() {
		return poes;
	}
	/**
	 * @param poes the poes to set
	 */
	public void setPoes(List<PoeEntity> poes) {
		this.poes = poes;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	} 

	
	
	
	
	
	
}



