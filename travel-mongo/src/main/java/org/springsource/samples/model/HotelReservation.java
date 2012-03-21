package org.springsource.samples.model;

public class HotelReservation {

	private String itineraryId;
	private String roomNumber;
	private String hotelName;


	public String getItineraryId() {
		return this.itineraryId;
	}

	public void setItineraryId(String itineraryId) {
		this.itineraryId = itineraryId;
	}

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
