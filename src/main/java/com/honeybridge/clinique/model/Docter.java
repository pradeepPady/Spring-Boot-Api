package com.honeybridge.clinique.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="docters")
public class Docter {
private String id;
private String name;
private String specilization;
private String avalability;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSpecilization() {
	return specilization;
}
public void setSpecilization(String specilization) {
	this.specilization = specilization;
}
public String getAvalability() {
	return avalability;
}
public void setAvalability(String avalability) {
	this.avalability = avalability;
}



}
