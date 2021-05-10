package com.finovate.parking.service.implementation;

import com.finovate.parking.dto.CarDTO;
import com.finovate.parking.dto.ParkingLotDTO;
import com.finovate.parking.dto.ResponseDTO;
import com.finovate.parking.dto.SlotDTO;
import com.finovate.parking.exception.ParkingLotException;
import com.finovate.parking.model.Car;
import com.finovate.parking.model.ParkingLotCar;
import com.finovate.parking.model.Slot;
import com.finovate.parking.repository.CarRepository;
import com.finovate.parking.repository.ParkingLotRepository;
import com.finovate.parking.repository.SlotRepository;
import com.finovate.parking.service.ICarService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
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
		List<Slot> slot1 = slotRepository.findAll();

		if (slot1.size() < 3) {
			// return new ResponseDTO("lot is full");
			ParkingLotCar parkingLot = parkingLotRepository.findById(UUID.fromString(slotDTO.getParkingLotUUID()))
					.orElseThrow(() -> new ParkingLotException("details not found!"));
			slot.setParkingLotCar(parkingLot);
			return slotRepository.save(slot);
		} else {
			return null;
		}

	}

	public Car carPark(CarDTO carDTO) {

		Car car = new Car(carDTO);
		car.setCreatedTimeStamp(LocalDateTime.now());
		Slot slot = slotRepository.findById(UUID.fromString(carDTO.getSlotUUID()))
				.orElseThrow(() -> new ParkingLotException("details not found!"));
		car.setSlot(slot);

		ParkingLotCar parkingLot = parkingLotRepository.findById(UUID.fromString(carDTO.getLotUUID()))
				.orElseThrow(() -> new ParkingLotException(" details not found !"));
		car.setParkingLotCar(parkingLot);
		return carRepository.save(car);
	}

	@Override
	public void unPark(UUID carNumber) {
		carRepository.deleteById(carNumber);
	}

	@Override
	public ResponseDTO checkParkinglotFullOrNot() {
		List<Slot> slot = slotRepository.findAll();
		if (slot.size() < 3) {
			return new ResponseDTO("lot is empty");
		} else {
			return new ResponseDTO("lot is full");
		}
	}

	@Override
	public List<Car> getAllcar() {
		List<Car> car = carRepository.findAll();
		return car;
	}

	@Override
	public List<Car> findByColor(String color) {
		List<Car> car = carRepository.findByColor(color);
		return car;
	}

	@Override
	public List<Car> findByModel(String color) {
		List<Car> car = carRepository.findByModel(color);
		return car;
	}

	@Override
	public List<Car> findByColorAndModel(String color, String model) {
		List<Car> car = carRepository.findByColorAndModel(color, model);
		return car;
	}

	@Override
	public ResponseDTO findParkingTime(String carUUID) {
		LocalDateTime parkTime = carRepository.findById(UUID.fromString(carUUID)).orElseThrow().getCreatedTimeStamp();
		LocalDateTime unParkTime = LocalDateTime.now();
		Duration timeDuration = Duration.between(parkTime, unParkTime);
		return new ResponseDTO(
				"Time taken: " + timeDuration.toHoursPart() + " Hr: " + timeDuration.toMinutesPart() + " minuts");
	}

}
