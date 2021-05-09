package com.finovate.parking.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finovate.parking.dto.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor // LOMBOK library
@ToString
@Entity
@Table(name="car_table")
public class Car implements Serializable {

	private static final long serialVersionUID = 7629581767757128364L; // used during deserialization to verify that the
																		// sender
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2") // universally unique identifier (UUID)
	@Column(name = "cid", columnDefinition = "BINARY(16)") // 16 byte array or a hexadecimal String value
	private UUID cid;
	private String platNumber;
	
	@Temporal(value = TemporalType.TIMESTAMP) // It's used to specify the desired SQL type.
	@Column(name = "in_time")
	private Date inTime;

	@JsonIgnore // used at field level to mark a property or list of properties to be ignored.
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "out_time")
	private Date outTime;
	@JsonIgnore 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Slot slot;
	@JsonIgnore 
	 @ManyToOne(fetch = FetchType.LAZY)
	private ParkingLotCar parkingLotCar;

	public Car(CarDTO carDTO) {
		this.platNumber = carDTO.getPlatNumber();

	}
}
