package com.parcka.ustersales.repository;

import com.parcka.ustersales.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {


    //Drivers que no tenga viaje asignado para el dia y que cumplan con la licencia del vehiculo
    @Query("SELECT d FROM Driver d left join Trip t on t.driver.id = d.id and t.date = ?1" +
            " where t.driver.id is null and d.license = ?2")
    List<Driver> findByNotInDateAndLicenseRequired(Date date, char licenseRequired);


}
