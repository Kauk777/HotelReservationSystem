package com.bridgelabz.HotelReservationSystem;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class HotelReservation 
{
	private List<HotelDetails> hotels;
	private static int lakewoodRating=3;
	private static int bridgewoodRating=4;
	private static int ridgewoodRating=5;
	
	public HotelReservation() {
		hotels=new ArrayList<>();
	}
	
	public void addDetails(String hName, int weekRate, int weekendRate) {
		HotelDetails hd=new HotelDetails(hName,weekRate,weekendRate);
		hotels.add(hd);
	}
	
	public String findCheapestHotel(int days) {
		Integer total[]=new Integer[3]; //total[0]:Lakewood, total[1]:Bridgewood, total[2]:Ridgewood
		int i=0;
		for(HotelDetails hd:hotels) {
			total[i]=days*(hd.getRateWeekday()+hd.getRateWeekend());
			i++;
		}
		int minCost=Math.min(total[0], Math.min(total[1], total[2]));
		if(minCost==total[0] && minCost==total[1])
		{
			System.out.println("Total cost: $"+minCost);
			return lakewoodRating>bridgewoodRating ? "Lakewood" : "Bridgewood";
		}
		else if(minCost==total[0] && minCost==total[2])
		{
			System.out.println("Total cost: $"+minCost);
			return lakewoodRating>ridgewoodRating ? "Lakewood" : "Ridgewood";
		}
		else if(minCost==total[1] && minCost==total[2])
		{
			System.out.println("Total cost: $"+minCost);
			return bridgewoodRating>ridgewoodRating ? "Bridgewood" : "Ridgewood";
		}
			
		else if(minCost==total[0])
		{
			System.out.println("Lakewood with total cost: $"+minCost);
			return "Lakewood";
		}
		else if(minCost==total[1])
		{
			System.out.println("Bridgewood with total cost: $"+minCost);
			return "Bridgewood";
		}	
		else
		{
			System.out.println("Ridgewood with total cost: $"+minCost);
			return "Ridgewood";
		}					
	}
	
    public static void main( String[] args )
    {
        System.out.println( "***Welcome to hotel reservation program***" );
        HotelReservation h=new HotelReservation();
        h.addDetails("Lakewood",110,90);
        h.addDetails("Bridgewood",150,50);
        h.addDetails("Ridgewood",220,150); 
        
        LocalDate startDate=LocalDate.of(2020, Month.SEPTEMBER, 11);
        LocalDate endDate=LocalDate.of(2020, Month.SEPTEMBER, 12);
        long noOfDays=ChronoUnit.DAYS.between(startDate,endDate);
        System.out.println((int)noOfDays);
        System.out.println(h.findCheapestHotel((int)noOfDays));
    }
}
