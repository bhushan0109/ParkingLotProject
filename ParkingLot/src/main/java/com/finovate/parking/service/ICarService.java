package com.finovate.parking.service;

import com.finovate.parking.dto.ParkingLotDTO;
import com.finovate.parking.dto.SlotDTO;
import com.finovate.parking.model.ParkingLotCar;
import com.finovate.parking.model.Slot;

public interface ICarService {

	public ParkingLotCar addParkingLot(ParkingLotDTO parkingLotDTO);
	 public Slot addSlot(SlotDTO slotDTO);

}
