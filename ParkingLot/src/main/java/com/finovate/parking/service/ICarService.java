package com.finovate.parking.service;

import com.finovate.parking.dto.ParkingLotDTO;
import com.finovate.parking.model.ParkingLotCar;

public interface ICarService {

	public ParkingLotCar addParkingLot(ParkingLotDTO parkingLotDTO);

}
