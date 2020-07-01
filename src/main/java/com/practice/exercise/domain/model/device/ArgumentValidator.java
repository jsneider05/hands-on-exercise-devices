package com.practice.exercise.domain.model.device;

import com.practice.exercise.domain.exception.DeviceException;


public final class ArgumentValidator {

	public static final String FIELD_REQUIRED_ERROR_MESSAGE = "The field %s is required";

	public static void validateRequired(Object value, String field) {
		if (value == null || value.toString().isBlank()) {
			throw new DeviceException(String.format(FIELD_REQUIRED_ERROR_MESSAGE, field));
		}
	}
	
	public static void validateNumeric(String value, String message) {
		try {
			Long.parseLong(value);
		} catch (NumberFormatException numberFormatException) {
			throw new DeviceException(message);
		}
	}

}
