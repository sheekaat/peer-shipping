package com.peer.ship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peer.ship.exception.PeerShipmentsNotFoundException;
import com.peer.ship.model.PeerShip;
import com.peer.ship.service.PeerShippingService;

@RestController
public class PeerShippingController {

	@Autowired
	private PeerShippingService peerShippingService;

	@RequestMapping(method = RequestMethod.POST, path = "/shipreq", consumes = { "application/json" }, produces = {
			"application/json" })
	public PeerShip addShippingRequest(@RequestBody PeerShip shippingReq) {
		return peerShippingService.addShippingRequest(shippingReq);
	}

	@GetMapping("/shipments/{id}")
	public Resource<PeerShip> getShippingRequestByShipmentId(@PathVariable String shipmentId) {
		PeerShip peerShippment = peerShippingService.getShippingRequestsByShipmentId(shipmentId);
		if(null == peerShippment) {
			throw new PeerShipmentsNotFoundException();
		}
		return new Resource<PeerShip>(peerShippment);
	} 
	
	public Resource<List<PeerShip>> getShippingRequests(@PathVariable String peerUniqueId, boolean excludeShipmentsDelivered) {
		List<PeerShip> peerShippingRequests = peerShippingService.getShippingRequestsByPeerId(peerUniqueId, excludeShipmentsDelivered);
		if(null == peerShippingRequests || peerShippingRequests.isEmpty()) {
			throw new PeerShipmentsNotFoundException();
		}
		return new Resource<List<PeerShip>>(peerShippingRequests);
	} 

}
