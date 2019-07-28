package com.parcka.ustersales.repository;

import com.parcka.ustersales.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Long> {
}
