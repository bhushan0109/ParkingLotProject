package com.finovate.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finovate.parking.dto.CarDTO;
import com.finovate.parking.dto.ResponseDTO;
import com.finovate.parking.model.Car;
import com.finovate.parking.service.ICarService;

@RestController
@RequestMapping("/car")
public class ParkingLotController {

	@Autowired
	private ICarService carService;

	@PostMapping("/park")
	public ResponseEntity<ResponseDTO> carPark(@RequestBody CarDTO carDTO) {
		Car car = carService.carPark(carDTO);
		ResponseDTO responseDto = new ResponseDTO("Parked car", car);
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/unpark/{id}")
	public ResponseEntity<ResponseDTO> deletcar(@PathVariable("id") Long id) {
		carService.unpark(id);
		ResponseDTO responseDTO = new ResponseDTO("unparked successfully  ", id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<ResponseDTO> getAllCar() {
		List<Car> carData = carService.getAllCar();
		ResponseDTO responseDTO = new ResponseDTO("Successfull got the data", carData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
