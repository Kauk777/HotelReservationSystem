package com.bridgelabz.HotelReservationSystem;

import java.util.*;

public class HotelDetails {
	private String hotelName;
	private int rateWeekday;
	private int rateWeekend;
	
	public HotelDetails(String hotelName, int rateWeekday, int rateWeekend) {
		this.hotelName = hotelName;
		this.rateWeekday = rateWeekday;
		this.rateWeekend=rateWeekend;
	}

	public int getRateWeekend() {
		return rateWeekend;
	}

	public void setRateWeekend(int rateWeekend) {
		this.rateWeekend = rateWeekend;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRateWeekday() {
		return rateWeekday;
	}

	public void setRateWeekday(int rateWeekday) {
		this.rateWeekday = rateWeekday;
	}
	
}
