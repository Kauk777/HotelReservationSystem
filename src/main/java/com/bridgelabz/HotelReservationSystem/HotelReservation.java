package com.bridgelabz.HotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

@FunctionalInterface
interface CheckValidation {
	boolean validation(String str) throws HotelReservationException;
}

public class HotelReservation {
	private static final Pattern CHECK_CUSTOMER_TYPE = Pattern.compile("^[A-Za-z]+$");
	private static final Pattern CHECK_DATE_RANGE = Pattern.compile("^[0-9,-]+$");

	private List<HotelDetails> hotelsRegular;
	private List<HotelDetails> hotelsReward;
	private static int lakewoodRating = 3;
	private static int bridgewoodRating = 4;
	private static int ridgewoodRating = 5;

	public HotelReservation() {
		hotelsRegular = new ArrayList<>();
		hotelsReward = new ArrayList<>();

	}

	public void addRegularDetails(String hName, int weekRate, int weekendRate) {
		HotelDetails hd = new HotelDetails(hName, weekRate, weekendRate);
		hotelsRegular.add(hd);
	}

	public void addRewardDetails(String hName, int weekRate, int weekendRate) {
		HotelDetails hd = new HotelDetails(hName, weekRate, weekendRate);
		hotelsReward.add(hd);
	}

	CheckValidation checkNullEmpty = (data) -> {
		try {
			if (data.length() == 0)
				throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_EMPTY,
						"Enter proper value");
		} catch (NullPointerException e) {
			throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_NULL,
					"Enter proper value");
		}
		return true;
	};

	CheckValidation checkCustTypeValidation = (String custType) -> {
		checkNullEmpty.validation(custType);
		boolean valid = CHECK_CUSTOMER_TYPE.matcher(custType).matches();
		if (!valid) {
			throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_INVALID,
					"Invalid entry, should contains only alphabets");
		}
		return valid;
	};

	CheckValidation checkDateRangeValidation = (String dateRange) -> {
		checkNullEmpty.validation(dateRange);
		boolean valid = CHECK_DATE_RANGE.matcher(dateRange).matches();
		if (!valid) {
			throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_INVALID,
					"Invalid entry, date range should meet format YYYY-MM-DD");
		}
		return valid;
	};

	public String findCheapestHotel(String input, String loyalty) {
		String arr[] = input.split(",");
		int numOfWeekdays = 0;
		int numOfWeekends = 0;
		for (int i = 0; i < arr.length; i++) {
			LocalDate date = LocalDate.parse(arr[i]);
			if (getDayNumber(date) == 6 || getDayNumber(date) == 7)
				numOfWeekends++;
			else
				numOfWeekdays++;
		}
		Integer total[] = new Integer[3]; // total[0]:LakewoodCost, total[1]:BridgewoodCost, total[2]:RidgewoodCost
		int i = 0;
		List<HotelDetails> hotels = new ArrayList<>();
		if (loyalty.equals("Regular"))
			hotels.addAll(hotelsRegular);
		else
			hotels.addAll(hotelsReward);

		for (HotelDetails hd : hotels) {
			total[i] = numOfWeekdays * (hd.getRateWeekday()) + numOfWeekends * (hd.getRateWeekend());
			i++;
		}
		int minCost = Math.min(total[0], Math.min(total[1], total[2]));
		if (minCost == total[0] && minCost == total[1]) {
			System.out.println("Total cost: $" + minCost + " for Lakewood and Bridgewood");
			return lakewoodRating > bridgewoodRating ? "Lakewood" : "Bridgewood";
		} else if (minCost == total[0] && minCost == total[2]) {
			System.out.println("Total cost: $" + minCost + " for Lakewood and Ridgewood");
			return lakewoodRating > ridgewoodRating ? "Lakewood" : "Ridgewood";
		} else if (minCost == total[1] && minCost == total[2]) {
			System.out.println("Total cost: $" + minCost + " for Ridgewood and Bridgewood");
			return bridgewoodRating > ridgewoodRating ? "Bridgewood" : "Ridgewood";
		}

		else if (minCost == total[0]) {
			System.out.println("Lakewood with total cost: $" + minCost + ",  Rating: " + lakewoodRating);
			return "Lakewood";
		} else if (minCost == total[1]) {
			System.out.println("Bridgewood with total cost: $" + minCost + ",  Rating: " + bridgewoodRating);
			return "Bridgewood";
		} else {
			System.out.println("Ridgewood with total cost: $" + minCost + ",  Rating: " + ridgewoodRating);
			return "Ridgewood";
		}
	}

	public String bestRatedHotel() {
		int maxRating = Math.max(lakewoodRating, Math.max(bridgewoodRating, ridgewoodRating));
		if (maxRating == lakewoodRating)
			return "Lakewood";
		else if (maxRating == bridgewoodRating)
			return "Bridgewood";
		else
			return "Ridgewood";
	}

	// Monday is 1 and Sunday is 7
	public int getDayNumber(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day.getValue();
	}

	public static void main(String[] args) {
		System.out.println("***Welcome to hotel reservation program***");
		HotelReservation hotel = new HotelReservation();
		hotel.addRegularDetails("Lakewood", 110, 90);
		hotel.addRegularDetails("Bridgewood", 150, 50);
		hotel.addRegularDetails("Ridgewood", 220, 150);

		hotel.addRewardDetails("Lakewood", 80, 80);
		hotel.addRewardDetails("Bridgewood", 110, 50);
		hotel.addRewardDetails("Ridgewood", 100, 40);
		
		String input1 = "2020-09-10,2020-09-11"; // YYYY-MM-DD format
		System.out.println("Cheapest hotel for regular customers: " + hotel.findCheapestHotel(input1, "Regular"));
		String input = "2020-09-11,2020-09-12";
		System.out.println("Cheapest best rated hotel for regular customers: " + hotel.findCheapestHotel(input, "Regular"));
		System.out.println("Best rated hotel: " + hotel.bestRatedHotel());
		System.out.println("Cheapest best rated hotel for reward customers: " + hotel.findCheapestHotel(input, "Reward"));
	}
}
