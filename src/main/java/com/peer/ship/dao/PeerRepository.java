package com.peer.ship.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.peer.ship.model.PeerShip;

public interface PeerRepository extends MongoRepository<List<PeerShip>, String>{}
