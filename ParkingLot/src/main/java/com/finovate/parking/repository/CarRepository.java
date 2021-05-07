package com.finovate.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finovate.parking.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
