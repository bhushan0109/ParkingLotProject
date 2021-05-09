package com.finovate.parking.service.implementation;

import com.finovate.parking.dto.ParkingLotDTO;
import com.finovate.parking.model.ParkingLotCar;
import com.finovate.parking.repository.CarRepository;
import com.finovate.parking.repository.ParkingLotRepository;
import com.finovate.parking.repository.SlotRepository;
import com.finovate.parking.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarImpl implements ICarService {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ParkingLotRepository parkingLotRepository;

	@Autowired
	private SlotRepository slotRepository;

	@Override
	public ParkingLotCar addParkingLot(ParkingLotDTO parkingLotDTO) {
		ParkingLotCar Lot = new ParkingLotCar(parkingLotDTO);
		return parkingLotRepository.save(Lot);
	}

}
