package com.bridgelabz.HotelReservationSystem;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class HotelTest 
{	
    @Test
    public void givenDateRange_WhenRewardCustomer_ShouldReturnTrue() 
    {
    	HotelReservation hotel=new HotelReservation();
    	String hotelName=hotel.findCheapestHotel("2020-09-11,2020-09-12","Reward");
        Assert.assertEquals("Ridgewood", hotelName);
    }
    
    @Test
    public void givenDateRange_WhenRegularCustomer_ShouldReturnTrue() 
    {
    	HotelReservation hotel=new HotelReservation();
    	String hotelName=hotel.findCheapestHotel("2020-09-11,2020-09-12","Regular");
        Assert.assertEquals("Bridgewood", hotelName);
    }
}
