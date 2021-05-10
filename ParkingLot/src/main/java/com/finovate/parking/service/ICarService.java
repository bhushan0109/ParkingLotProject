package com.finovate.parking.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.finovate.parking.dto.CarDTO;
import com.finovate.parking.dto.ParkingLotDTO;
import com.finovate.parking.dto.ResponseDTO;
import com.finovate.parking.dto.SlotDTO;
import com.finovate.parking.model.Car;
import com.finovate.parking.model.ParkingLotCar;
import com.finovate.parking.model.Slot;

public interface ICarService {

	public ParkingLotCar addParkingLot(ParkingLotDTO parkingLotDTO);

	public Slot addSlot(SlotDTO slotDTO);

	public Car carPark(CarDTO carDTO);

	void unPark(UUID carNumber);

	ResponseDTO checkParkinglotFullOrNot();

	public List<Car> getAllcar();

	public List<Car> findByColor(String color);
	public List<Car> findByModel(String color);

	public List<Car> findByColorAndModel(String color, String model);

}
