package com.bridgelabz.HotelReservationSystem;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class HotelReservation 
{
	private List<HotelDetails> hotels;
	
	public HotelReservation() {
		hotels=new ArrayList<>();
	}
	
	public void addDetails(String hName, int Rate) {
		HotelDetails hd=new HotelDetails(hName,Rate);
		hotels.add(hd);
	}
	
	public String findCheapestHotel(int days) {
		for(HotelDetails hd:hotels) {
			int total=0;
			for(int i=0;i<=days;i++)
				total+=hd.getRateWeekdayRegCust();
			hd.setRateWeekdayRegCust(total);
		}
		HotelDetails minRate=Collections.min(hotels);
		System.out.println("Cheapest Hotel: "+minRate);
		return minRate.getHotelName();
	}
	
    public static void main( String[] args )
    {
        System.out.println( "***Welcome to hotel reservation program***" );
        HotelReservation h=new HotelReservation();
        h.addDetails("Lakewood",110);
        h.addDetails("Bridgewood",160);
        h.addDetails("Ridgewood",220); 
        
        LocalDate startDate=LocalDate.of(2020, Month.SEPTEMBER, 10);
        LocalDate endDate=LocalDate.of(2020, Month.SEPTEMBER, 11);
        long noOfDays=ChronoUnit.DAYS.between(startDate,endDate);
        System.out.println((int)noOfDays);
        System.out.println(h.findCheapestHotel((int)noOfDays));
    }
}
