package com.finovate.parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finovate.parking.dto.ParkingLotDTO;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="parkinglot_table")
public class ParkingLotCar implements Serializable {

	private static final long serialVersionUID = 7737732509833641214L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2") // universally unique identifier (UUID)
	@Column(name = "pid", columnDefinition = "BINARY(16)") // 16 byte array or a hexadecimal String value
	private UUID pid;
	private int parkingLotId;
	private String parkingLotName;

	@JsonIgnore
    @OneToMany(mappedBy = "parkingLotCar")
	public List<Slot> slots;

	@JsonIgnore
    @OneToMany(mappedBy = "parkingLotCar")
	public List<Car> car;

	public ParkingLotCar(ParkingLotDTO parkingLotDTO) {
		this.parkingLotId = parkingLotDTO.lotId;
		this.parkingLotName = parkingLotDTO.parkingLotName;
	}
}
