package com.peers.reg.model;


public class PeerIdentity {

	private String idType;
	private String idValue;
	private String idDoc;

	
	public String getIdValue() {
		return idValue;
	}
	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(String idDoc) {
		this.idDoc = idDoc;
	}
}
