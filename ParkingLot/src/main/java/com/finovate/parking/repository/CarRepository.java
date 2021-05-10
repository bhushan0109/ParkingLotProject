package com.finovate.parking.repository;



import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finovate.parking.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
	List<Car> findByColor(String color);

	List<Car> findByModel(String model);

	List<Car> findByColorAndModel(String color, String model);
	

	/*
	 * List<Car> findByInTimeAnd(Date inTime);
	 * 
	 * List<Car> findByOutTime(Date outTime);
	 */

	LocalDateTime findByPlateNumber(String plateNumber);

	

}