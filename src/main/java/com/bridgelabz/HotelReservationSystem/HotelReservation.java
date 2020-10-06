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
	
	public void addDetails(String hName, int weekRate, int weekendRate) {
		HotelDetails hd=new HotelDetails(hName,weekRate,weekendRate);
		hotels.add(hd);
	}
	
    public static void main( String[] args )
    {
        System.out.println( "***Welcome to hotel reservation program***" );
        HotelReservation h=new HotelReservation();
        h.addDetails("Lakewood",110,90);
        h.addDetails("Bridgewood",150,50);
        h.addDetails("Ridgewood",220,150); 
    }
}
