package com.peers.reg.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Peers")
public class Peer extends PeerKey{
	
	private String firstName;
	private String lastName;
	private String middleName;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}	
}
