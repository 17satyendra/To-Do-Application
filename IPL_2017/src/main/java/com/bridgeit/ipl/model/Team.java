package com.bridgeit.ipl.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * This is a simple pojo or DTO class.
 * In this class Team about his information with one default constructor &
 * getter/setter 
 * with mapped database using Annotation. 
 * @author bridgeit
 * @version 1.8
 * @since 2017-03-01
 */
@Entity
@Table(name="Team_Details")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	private Long id;
	private String name;
	private String coach;
	private String owner;
	private String captain;
	private String logo;
	private String homevenue;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getHomevenue() {
		return homevenue;
	}

	public void setHomevenue(String homevenue) {
		this.homevenue = homevenue;
	}
}
