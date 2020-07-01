package com.practice.exercise.domain.exception;

public class DeviceException extends RuntimeException {

	private static final long serialVersionUID = 6759407566706191023L;

	public DeviceException(String mensaje) {
		super(mensaje);
	}

}