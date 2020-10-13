package com.bridgelabz.HotelReservationSystem;

public class HotelReservationException extends Exception {
	enum ExceptionType {
		ENTERED_NULL,ENTERED_EMPTY,ENTERED_INVALID
	}
	
	ExceptionType exceptionType;

	public HotelReservationException(ExceptionType exceptionType, String message) {
		super(message);
		this.exceptionType=exceptionType;
	}

}
