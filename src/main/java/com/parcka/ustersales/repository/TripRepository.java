package com.parcka.ustersales.repository;

import com.parcka.ustersales.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Long> {
}
