package com.example.placeservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.placeservice.api.PlaceRequest;
import com.example.placeservice.api.PlaceResponse;
import com.example.placeservice.domain.Place;
import com.example.placeservice.services.PlaceService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

  private PlaceService placeService;

  public PlaceController(PlaceService placeService) {
    this.placeService = placeService;
  }

  @PostMapping
  public ResponseEntity<Mono<PlaceResponse>> create(@RequestBody PlaceRequest request) {
    var PlaceResponse = placeService.create(request).map(PlaceMapper::fromPlaceToResponse);
    return ResponseEntity.status(HttpStatus.CREATED).body(PlaceResponse);
  }

}
