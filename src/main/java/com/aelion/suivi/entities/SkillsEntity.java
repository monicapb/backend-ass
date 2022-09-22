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
@Table(name = "skill")
public class SkillsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 150, nullable = false, unique = true)
	private String title;
	
	
	//@OneToMany(mappedBy = "skill")
	//private List<InternEvaluationEntity> evaluations = new ArrayList<>();
	
	@Column(length = 255)
	private String description;
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
