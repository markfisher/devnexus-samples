package org.springsource.samples.model;

public class CarReservation {

	private String itineraryId;
	private String carSize;
	private String rentalAgency;

	public void setItineraryId(String itineraryId) {
		this.itineraryId = itineraryId;
	}

	public String getItineraryId() {
		return this.itineraryId;
	}

	public String getCarSize() {
		return carSize;
	}

	public void setCarSize(String carSize) {
		this.carSize = carSize;
	}

	public String getRentalAgency() {
		return rentalAgency;
	}

	public void setRentalAgency(String rentalAgency) {
		this.rentalAgency = rentalAgency;
	}

	public String toString() {
		return this.carSize + " from  " + this.rentalAgency;
	}
}
