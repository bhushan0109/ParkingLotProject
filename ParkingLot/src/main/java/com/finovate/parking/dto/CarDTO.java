package com.finovate.parking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDTO {
	private String platNumber;
	public String lotUUID;
	public String slotUUID;
	private String color;
	private String model;
}
