package com.bridgelabz.HotelReservationSystem;

import java.util.*;

public class HotelDetails implements Comparable {
	private String hotelName;
	private int rateWeekdayRegCust;
	
	public HotelDetails(String hotelName, int rateWeekdayRegCust) {
		this.hotelName = hotelName;
		this.rateWeekdayRegCust = rateWeekdayRegCust;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRateWeekdayRegCust() {
		return rateWeekdayRegCust;
	}

	public void setRateWeekdayRegCust(int rateWeekdayRegCust) {
		this.rateWeekdayRegCust = rateWeekdayRegCust;
	}
	
	@Override
	public String toString() {
		return hotelName + ", Total Rates: $" + rateWeekdayRegCust;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int compareRate=((HotelDetails)o).getRateWeekdayRegCust();
		return this.rateWeekdayRegCust-compareRate;
	}	
}
