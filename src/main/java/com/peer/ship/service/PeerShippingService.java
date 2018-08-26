package com.peer.ship.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.ship.dao.PeerRepository;
import com.peer.ship.dao.PeerShippingRepository;
import com.peer.ship.model.PeerShip;

@Service
public class PeerShippingService {

	@Autowired
	private PeerShippingRepository peerShippingRepo;
	
	@Autowired
	private PeerRepository peerRepo;
	
	public PeerShip addShippingRequest(PeerShip shippingReq) {
		return peerShippingRepo.insert(shippingReq);
	}

	public List<PeerShip> getShippingRequestsByPeerId(String peerUniqueId, boolean excludeShipmentsDelivered) {
		Optional<List<PeerShip>> peerShipList = peerRepo.findById(peerUniqueId);
		if(peerShipList.isPresent()) {
			if(excludeShipmentsDelivered) {
			return peerShipList.get()
					.stream()
					.filter(peership -> Boolean.FALSE.equals(peership.getMarkAsDelivered()))
					.sorted((peership1, peership2) -> peership1.getLastUpdateDate().compareTo(peership2.getLastUpdateDate()))
					.collect(Collectors.toList());
			} else {
				return peerShipList.get()
						.stream()
						.sorted((peership1, peership2) -> peership1.getLastUpdateDate().compareTo(peership2.getLastUpdateDate()))
						.collect(Collectors.toList());
			}
		}
		return null;
	}

	public PeerShip getShippingRequestsByShipmentId(String shipmentId) {
		Optional<PeerShip> peerShipment = peerShippingRepo.findById(shipmentId);
		if(peerShipment.isPresent()) {
			return peerShipment.get();
		}
		return null;
	}
}
