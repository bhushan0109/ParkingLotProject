package com.finovate.parking.service;

import java.util.List;

import com.finovate.parking.dto.CarDTO;
import com.finovate.parking.model.Car;

public interface ICarService {

	Car carPark(CarDTO carDTO);

	List<Car> getAllCar();

	void unpark(Long id);

}
