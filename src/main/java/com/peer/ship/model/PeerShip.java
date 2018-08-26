package com.peer.ship.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Shipment")
@Getter
@Setter
@ToString
public class PeerShip {

	@Id
	private String id;
	private String itemName;
	private String description;
	private String category;
	private double weight;
	private double priceToShip;
	private Boolean fixOnPrice;
	private Boolean markAsDelivered;
	private Boolean pickupOnly;
	private String pickupNearDestinationDesc;
	private Boolean dropoffOnly;
	private String dropoffNearDestinationDesc;
	private Date creationDate;
	private Date lastUpdateDate;
	private Location pickupLocation;
	private Location deliverLocation;
	private List<Image> itemPics;

}
