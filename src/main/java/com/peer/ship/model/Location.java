package com.peer.ship.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Location {

	private String zipCode;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;

}
