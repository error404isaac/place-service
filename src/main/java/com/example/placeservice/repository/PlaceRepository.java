package com.example.placeservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.placeservice.domain.Place;

public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {

}
