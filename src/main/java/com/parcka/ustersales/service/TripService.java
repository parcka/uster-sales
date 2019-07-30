package com.parcka.ustersales.service;

import com.parcka.ustersales.model.Trip;

import com.parcka.ustersales.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {


    @Autowired
    TripRepository tripRepository;

    public Trip save(Trip Trip) {
        return tripRepository.saveAndFlush(Trip);

    }

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    public Optional<Trip> findByID(Long id) {
        return tripRepository.findById(id);
    }

    public void delete(Trip Trip) {
        tripRepository.delete(Trip);
    }

    public void deleteById(long id) {
        tripRepository.deleteById(id);
    }

}
