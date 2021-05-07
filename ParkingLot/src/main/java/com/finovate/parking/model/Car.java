package com.finovate.parking.model;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finovate.parking.dto.CarDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	private String platNumber;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "in_time", nullable = false)
	private Date inTime;
	@JsonIgnore
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "out_time")
	private Date outTime;

	public Car(CarDTO carDTO) {
		this.platNumber = carDTO.getPlatNumber();

	}
}
