package com.peer.ship.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.peer.ship.model.PeerShip;

public interface PeerShippingRepository extends MongoRepository<PeerShip, String>{}
