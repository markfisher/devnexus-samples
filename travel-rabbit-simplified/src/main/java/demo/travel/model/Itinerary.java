package demo.travel.model;

public class Itinerary {

	private String id;
	private String username;
	private String startDate;
	private String endDate;
	private FlightReservation flightReservation;
	private HotelReservation hotelReservation;
	private CarReservation carReservation;

	public Itinerary() {
		this.id = null;
	}

	public Itinerary(String id) {
		this.id = id;
	}

	public void set_id(String id) {
		this.id = id;
	}

	public String get_id() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public FlightReservation getFlightReservation() {
		return flightReservation;
	}

	public void setFlightReservation(FlightReservation flightReservation) {
		this.flightReservation = flightReservation;
	}

	public HotelReservation getHotelReservation() {
		return hotelReservation;
	}

	public void setHotelReservation(HotelReservation hotelReservation) {
		this.hotelReservation = hotelReservation;
	}

	public CarReservation getCarReservation() {
		return carReservation;
	}

	public void setCarReservation(CarReservation carReservation) {
		this.carReservation = carReservation;
	}

	@Override
	public String toString() {
		return "Itinerary [id=" + id + ", username=" + username
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", flightReservation=" + flightReservation
				+ ", hotelReservation=" + hotelReservation
				+ ", carReservation=" + carReservation + "]";
	}

}
