package com.bridgeit.toDoApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Picture {
	
	@JsonProperty("data")
	private FBProfileData data;

	public FBProfileData getData() {
		return data;
	}

	public void setData(FBProfileData data) {
		this.data = data;
	}
	
}
