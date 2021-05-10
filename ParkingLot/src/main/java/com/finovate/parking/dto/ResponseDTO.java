package com.finovate.parking.dto;

import com.finovate.parking.model.Slot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTO {

	public String message;

	private Object data;

	public ResponseDTO(String message) {
		super();
		this.message = message;
	}

	

}