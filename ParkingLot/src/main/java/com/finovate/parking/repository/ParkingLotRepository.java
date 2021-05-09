package com.finovate.parking.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finovate.parking.model.ParkingLotCar;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLotCar,UUID>{
}