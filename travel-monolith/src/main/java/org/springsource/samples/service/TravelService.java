package org.springsource.samples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springsource.samples.data.CarReservationRepository;
import org.springsource.samples.data.FlightReservationRepository;
import org.springsource.samples.data.HotelReservationRepository;
import org.springsource.samples.data.ItineraryRepository;
import org.springsource.samples.model.CarReservation;
import org.springsource.samples.model.FlightReservation;
import org.springsource.samples.model.HotelReservation;
import org.springsource.samples.model.Itinerary;

@Controller
public class TravelService {

	private final ItineraryRepository itineraryRepository;
	private final FlightReservationRepository flightReservationRepository;
	private final HotelReservationRepository hotelReservationRepository;
	private final CarReservationRepository carReservationRepository;

	@Autowired
	public TravelService(ItineraryRepository itineraryRepository,
			FlightReservationRepository flightReservationRepository,
			HotelReservationRepository hotelReservationRepository,
			CarReservationRepository carReservationRepository) {
		this.itineraryRepository = itineraryRepository;
		this.flightReservationRepository = flightReservationRepository;
		this.hotelReservationRepository = hotelReservationRepository;
		this.carReservationRepository = carReservationRepository;
	}

	public List<Itinerary> getItinerariesForUser(String username) {
		List<Itinerary> itineraries = this.itineraryRepository.find(username);
		for (Itinerary itinerary : itineraries) {
			String itineraryId = itinerary.getId();
			FlightReservation flight = this.flightReservationRepository.find(itineraryId);
			if (flight != null) { itinerary.setFlightReservation(flight); }
			HotelReservation hotel = this.hotelReservationRepository.find(itineraryId);
			if (hotel != null) { itinerary.setHotelReservation(hotel); }
			CarReservation car = this.carReservationRepository.find(itineraryId);
			if (car != null) { itinerary.setCarReservation(car); }
		}
		return itineraries;
	}

	public void addItinerary(Itinerary itinerary) {
		String itineraryId = this.itineraryRepository.add(itinerary);
		System.out.println("itin ID is: " + itineraryId);
		this.flightReservationRepository.add(itinerary.getFlightReservation(), itineraryId);
		this.hotelReservationRepository.add(itinerary.getHotelReservation(), itineraryId);
		this.carReservationRepository.add(itinerary.getCarReservation(), itineraryId);
	}

}
