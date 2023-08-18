package com.example.placeservice.services;

import com.example.placeservice.api.PlaceRequest;
import com.example.placeservice.domain.Place;
import com.example.placeservice.repository.PlaceRepository;

import reactor.core.publisher.Mono;

public class PlaceService {
  private PlaceRepository placeRepository;

  public PlaceService(PlaceRepository placeRepository) {
    this.placeRepository = placeRepository;
  }

  public Mono<Place> create(PlaceRequest placeRequest) {
    var place = new Place(null, placeRequest.name(), placeRequest.slug(), placeRequest.state(),
        placeRequest.createdAt(), placeRequest.updatedAt());
    return placeRepository.save(place);
  }

}