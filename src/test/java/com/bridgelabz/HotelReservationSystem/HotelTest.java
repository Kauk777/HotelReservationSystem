package com.bridgelabz.HotelReservationSystem;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class HotelTest 
{	
    @Test
    public void givenDateRange_WhenHotelProper_ShouldReturnTrue() 
    {
    	HotelReservation hotel=new HotelReservation();
    	String hotelName=hotel.findCheapestHotel(1);
        Assert.assertEquals("Lakewood and Bridgewood", hotelName);
    }
}
