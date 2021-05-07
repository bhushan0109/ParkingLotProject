package com.finovate.parking.service.implementation;

import com.finovate.parking.dto.CarDTO;
import com.finovate.parking.model.Car;
import com.finovate.parking.repository.CarRepository;
import com.finovate.parking.service.ICarService;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarImpl implements ICarService {
	@Autowired
	CarRepository carRepository;

	@Override
	public Car carPark(CarDTO carDTO) {
		Car car = new Car(carDTO);
		car.setInTime(new Date());
		int IS_Available = 1;

		int park = 1;
		if (park == IS_Available) {
			log.info("car is parked");
			return carRepository.save(car);
		}

		return null;
	}

	@Override
	public List<Car> getAllCar() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

	@Override

	public void unpark(Long id) {
		
		  int IS_Available = 1;
		  
		  int park = 1;
		  if (park == IS_Available) 
		  { 
			  log.info("car is unparked");
		  }
		 
			carRepository.deleteById(id);
		}

	}
