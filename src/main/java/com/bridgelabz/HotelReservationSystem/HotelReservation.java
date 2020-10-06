package com.bridgelabz.HotelReservationSystem;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class HotelReservation 
{
	private List<HotelDetails> hotelsRegular;
	private List<HotelDetails> hotelsReward;
	private static int lakewoodRating=3;
	private static int bridgewoodRating=4;
	private static int ridgewoodRating=5;
	
	public HotelReservation() {
		hotelsRegular=new ArrayList<>();
		hotelsReward=new ArrayList<>();
		
	}
	
	public void addRegularDetails(String hName, int weekRate, int weekendRate) {
		HotelDetails hd=new HotelDetails(hName,weekRate,weekendRate);
		hotelsRegular.add(hd);
	}
	
	public void addRewardDetails(String hName, int weekRate, int weekendRate) {
		HotelDetails hd=new HotelDetails(hName,weekRate,weekendRate);
		hotelsReward.add(hd);
	}
	
	public String findCheapestHotel(int days, String loyalty) {
		Integer total[]=new Integer[3]; //total[0]:Lakewood, total[1]:Bridgewood, total[2]:Ridgewood
		int i=0;
		List<HotelDetails> hotels=new ArrayList<>();
		if(loyalty.equals("Regular"))
			hotels.addAll(hotelsRegular);
		else
			hotels.addAll(hotelsReward);
		
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
	
	public String bestRatedHotel() {
		int maxRating=Math.max(lakewoodRating, Math.max(bridgewoodRating, ridgewoodRating));
		if(maxRating==lakewoodRating)
			return "Lakewood";
		else if(maxRating==bridgewoodRating)
			return "Bridgewood";
		else 
			return "Ridgewood";
	}
	
    public static void main( String[] args )
    {
        System.out.println( "***Welcome to hotel reservation program***" );
        HotelReservation h=new HotelReservation();
        h.addRegularDetails("Lakewood",110,90);
        h.addRegularDetails("Bridgewood",150,50);
        h.addRegularDetails("Ridgewood",220,150); 
        
        h.addRewardDetails("Lakewood",80,80);
        h.addRewardDetails("Bridgewood",110,50);
        h.addRewardDetails("Ridgewood",100,40);
        
        LocalDate startDate=LocalDate.of(2020, Month.SEPTEMBER, 11);
        LocalDate endDate=LocalDate.of(2020, Month.SEPTEMBER, 12);
        long noOfDays=ChronoUnit.DAYS.between(startDate,endDate);
        System.out.println("Number of days: "+(int)noOfDays);
        System.out.println("Cheapest best rated hotel for regular customers: "+h.findCheapestHotel((int)noOfDays,"Regular"));
        System.out.println("Best rated hotel: "+h.bestRatedHotel());
        System.out.println("Cheapest best rated hotel for reward customers: "+h.findCheapestHotel((int)noOfDays,"Reward"));
    }
}
