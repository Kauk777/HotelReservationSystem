package com.bridgelabz.HotelReservationSystem;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class HotelTest 
{	
    @Test
    public void givendateRange_WhenHotelProper_ShouldReturnTrue() 
    {
    	HotelReservation h=new HotelReservation();
    	String hName=h.findCheapestHotel(1);
        Assert.assertEquals("Lakewood",hName);
    }
}
