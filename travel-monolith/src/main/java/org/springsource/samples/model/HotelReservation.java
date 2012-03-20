package org.springsource.samples.model;

public class HotelReservation {

	private String roomNumber;
	private String hotelName;

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String toString() {
		return this.hotelName + ", room " + this.roomNumber;
	}
}
