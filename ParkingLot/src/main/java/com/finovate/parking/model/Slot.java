package com.finovate.parking.model;
import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car_slot")
public class Slot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -574638321109453743L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2") // universally unique identifier (UUID)
	@Column(name = "sid", columnDefinition = "BINARY(16)") // 16 byte array or a hexadecimal String value
	private UUID sid;
	private String slotNumber;
	@ManyToOne
	@JsonIgnore
	@JoinColumn
	private ParkingLotCar parkingLotCar;

}