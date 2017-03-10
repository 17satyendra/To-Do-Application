package com.country.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Country")
public class Country implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name="genric",strategy="increment")
	@GeneratedValue(generator="genric")
	@Id
	private int id;
	private String name;
	private int area;
	private Long population;
	private String currerncy;
	private String lastModified;
	
	
	public Country() {	}
	public Country(int id, String name, int area, Long population, String currerncy,
			String lastModified) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.population = population;
		this.currerncy = currerncy;
		this.lastModified = lastModified;
	}
	
	public boolean isNew(){
		return id==0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	public String getCurrerncy() {
		return currerncy;
	}
	public void setCurrerncy(String currerncy) {
		this.currerncy = currerncy;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
}
