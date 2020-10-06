package com.bridgelabz.HotelReservationSystem;

import java.util.ArrayList;
import java.util.*;

public class HotelReservation 
{
	private List<HotelDetails> hotels;
	
	public HotelReservation() {
		hotels=new ArrayList<>();
	}
	
	public void addDetails(String hName, int weekReg, int wkndReg) {
		HotelDetails hd=new HotelDetails(hName,weekReg,wkndReg);
		hotels.add(hd);
	}
	
    public static void main( String[] args )
    {
        System.out.println( "***Welcome to hotel reservation program***" );
        HotelReservation h=new HotelReservation();
        h.addDetails("Lakewood",110,90);
        h.addDetails("Bridgewood",160,60);
        h.addDetails("Ridgewood",220,150);  
    }
}
