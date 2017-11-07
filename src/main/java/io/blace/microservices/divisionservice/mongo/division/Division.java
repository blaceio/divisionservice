package io.blace.microservices.divisionservice.mongo.division;

import org.springframework.data.annotation.Id;

public class Division {
	
	@Id
	private String id;
	
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Region [id=" + id + ", description=" + description + "]";
	}
}
