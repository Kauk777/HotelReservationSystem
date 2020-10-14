package com.bridgelabz.HotelReservationSystem;

import org.junit.Assert;
import org.junit.Test;

public class HotelTest {
	@Test
	public void givenCustomerType_WhenProper_ShouldReturnTrue() {
		HotelReservation validator = new HotelReservation();
		boolean result;
		try {
			result = validator.checkCustTypeValidation.validation("Regular");
			Assert.assertEquals(true, result);
		} catch (HotelReservationException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenCustomerType_WhenNull_ShouldThrowNullException() {
		HotelReservation validator = new HotelReservation();
		boolean result;
		try {
			result = validator.checkCustTypeValidation.validation(null);
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println(e.exceptionType);
			Assert.assertEquals("Enter proper value", e.getMessage());
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_NULL, e.exceptionType);
		}
	}

	@Test
	public void givenCustomerType_WhenEmpty_ShouldThrowEmptyException() {
		HotelReservation validator = new HotelReservation();
		boolean result;
		try {
			result = validator.checkCustTypeValidation.validation("");
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println(e.exceptionType);
			Assert.assertEquals("Enter proper value", e.getMessage());
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_EMPTY, e.exceptionType);
		}
	}

	@Test
	public void givenCustomerType_WhenInvalid_ShouldThrowInvalidException() {
		HotelReservation validator = new HotelReservation();
		boolean result;
		try {
			result = validator.checkCustTypeValidation.validation("Reg_ular");
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println(e.exceptionType);
			Assert.assertEquals("Invalid entry, should contains only alphabets", e.getMessage());
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_INVALID, e.exceptionType);
		}
	}

	@Test
	public void givenDateRange_WhenProper_ShouldReturnTrue() {
		HotelReservation validator = new HotelReservation();
		boolean result;
		try {
			result = validator.checkDateRangeValidation.validation("2020-09-10,2020-09-11");
			Assert.assertEquals(true, result);
		} catch (HotelReservationException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenDateRange_WhenNull_ShouldThrowNullException() {
		HotelReservation validator = new HotelReservation();
		boolean result;
		try {
			result = validator.checkDateRangeValidation.validation(null);
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println(e.exceptionType);
			Assert.assertEquals("Enter proper value", e.getMessage());
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_NULL, e.exceptionType);
		}
	}

	@Test
	public void givenDateRange_WhenEmpty_ShouldThrowEmptyException() {
		HotelReservation validator = new HotelReservation();
		boolean result;
		try {
			result = validator.checkDateRangeValidation.validation("");
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println(e.exceptionType);
			Assert.assertEquals("Enter proper value", e.getMessage());
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_EMPTY, e.exceptionType);
		}
	}

	@Test
	public void givenDateRange_WhenInvalid_ShouldThrowInvalidException() {
		HotelReservation validator = new HotelReservation();
		boolean result;
		try {
			result = validator.checkDateRangeValidation.validation("2020-aug-04,2020-5-14");
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
			System.out.println(e.exceptionType);
			Assert.assertEquals("Invalid entry, date range should meet format YYYY-MM-DD", e.getMessage());
			Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_INVALID, e.exceptionType);
		}
	}
	
	@Test
	public void givenDateRange_CheapestHotelForRegularCustomer_ShouldReturnResult() {
		HotelReservation hotel = new HotelReservation();
		hotel.addRegularDetails("Lakewood", 110, 90);
		hotel.addRegularDetails("Bridgewood", 150, 50);
		hotel.addRegularDetails("Ridgewood", 220, 150);
		String getHotel=hotel.findCheapestHotel("2020-09-10,2020-09-11", "Regular");
		Assert.assertEquals("Lakewood", getHotel);

	}
	
	@Test
	public void givenDateRange_CheapestRatedHotelForRegularCustomer_ShouldReturnResult() {
		HotelReservation hotel = new HotelReservation();
		hotel.addRegularDetails("Lakewood", 110, 90);
		hotel.addRegularDetails("Bridgewood", 150, 50);
		hotel.addRegularDetails("Ridgewood", 220, 150);
		String getHotel=hotel.findCheapestHotel("2020-09-11,2020-09-12", "Regular");
		Assert.assertEquals("Bridgewood", getHotel);

	}
	
	@Test
	public void givenDateRange_BestRatedHotelForRegularCustomer_ShouldReturnResult() {
		HotelReservation hotel = new HotelReservation();
		hotel.addRegularDetails("Lakewood", 110, 90);
		hotel.addRegularDetails("Bridgewood", 150, 50);
		hotel.addRegularDetails("Ridgewood", 220, 150);
		String getHotel=hotel.bestRatedHotel();
		Assert.assertEquals("Ridgewood", getHotel);

	}
	
	@Test
	public void givenDateRange_CheapestRatedHotelForRewardCustomer_ShouldReturnResult() {
		HotelReservation hotel = new HotelReservation();
		hotel.addRewardDetails("Lakewood", 80, 80);
		hotel.addRewardDetails("Bridgewood", 110, 50);
		hotel.addRewardDetails("Ridgewood", 100, 40);
		String getHotel=hotel.findCheapestHotel("2020-09-11,2020-09-12", "Reward");
		Assert.assertEquals("Ridgewood", getHotel);

	}
}
