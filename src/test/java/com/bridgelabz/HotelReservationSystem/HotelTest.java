package com.bridgelabz.HotelReservationSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelTest 
{
	HotelReservation hotelObj;
	
	@Before
	public void initial() {
		hotelObj=new HotelReservation();
	}
	
    @Test
    public void givenMessage_WhenHotelNameProper_ShouldReturnTrue()
    {
    	String str="Lakewood";
        Assert.assertEquals("Lakewood",str);
    }
}
