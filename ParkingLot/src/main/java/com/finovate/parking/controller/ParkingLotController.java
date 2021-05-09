package com.finovate.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finovate.parking.dto.ParkingLotDTO;
import com.finovate.parking.dto.ResponseDTO;
import com.finovate.parking.dto.SlotDTO;
import com.finovate.parking.service.ICarService;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {

	@Autowired
	private ICarService carService;

	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addParkingLot(@RequestBody ParkingLotDTO parkingLotDTO) {
		ResponseDTO responseDTO= new ResponseDTO("Added parking lot", carService.addParkingLot(parkingLotDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/add/slot")
	public ResponseEntity<ResponseDTO> addSlot(@RequestBody SlotDTO slotDTO) {
		ResponseDTO responseDTO = new ResponseDTO("added new slot into parking lot", carService.addSlot(slotDTO));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
