package com.bridgelabz.HotelReservationSystem;

public class HotelDetails {
	private String hotelName;
	private int rateWeekdayRegCust;
	private int rateWeekendRegCust;
	
	public HotelDetails(String hotelName, int rateWeekdayRegCust, int rateWeekendRegCust) {
		this.hotelName = hotelName;
		this.rateWeekdayRegCust = rateWeekdayRegCust;
		this.rateWeekendRegCust=rateWeekendRegCust;
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

	public int getRateWeekendRegCust() {
		return rateWeekendRegCust;
	}

	public void setRateWeekendRegCust(int rateWeekendRegCust) {
		this.rateWeekendRegCust = rateWeekendRegCust;
	}
	
}
