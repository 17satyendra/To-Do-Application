package com.bridgeit.toDoApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FBProfileData {

	private boolean is_silhouette;
	
	private String url;
	
	public boolean isIs_silhouette() {
		return is_silhouette;
	}
	public void setIs_silhouette(boolean is_silhouette) {
		this.is_silhouette = is_silhouette;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
