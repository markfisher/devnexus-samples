package org.springsource.samples.model;

public class CarReservation {

	private String carSize;
	private String rentalAgency;

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
