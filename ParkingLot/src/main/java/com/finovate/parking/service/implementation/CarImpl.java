package com.finovate.parking.service.implementation;

import com.finovate.model.Address;
import com.finovate.parking.dto.ParkingLotDTO;
import com.finovate.parking.dto.SlotDTO;
import com.finovate.parking.exception.ParkingLotException;
import com.finovate.parking.model.ParkingLotCar;
import com.finovate.parking.model.Slot;
import com.finovate.parking.repository.CarRepository;
import com.finovate.parking.repository.ParkingLotRepository;
import com.finovate.parking.repository.SlotRepository;
import com.finovate.parking.service.ICarService;

import java.util.UUID;

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

	@Override
	public Slot addSlot(SlotDTO slotDTO) {
		Slot slot = new Slot(slotDTO);
		ParkingLotCar parkingLot = parkingLotRepository.findById(UUID.fromString(slotDTO.getParkingLotUUID()))
				.orElseThrow(() -> new ParkingLotException("details not found!"));
		slot.setParkingLotCar(parkingLot);
		return slotRepository.save(slot);
	}

}
