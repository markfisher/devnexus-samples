package org.springsource.samples.model;

public class FlightReservation {

	private String itineraryId;
	private String seatNumber;
	private String flightNumber;

	public String getItineraryId() {
		return this.itineraryId;
	}

	public void setItineraryId(String itineraryId) {
		this.itineraryId = itineraryId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String toString() {
		return this.flightNumber + ", seat " + this.seatNumber;
	}
}
