package org.springsource.samples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springsource.samples.data.ItineraryRepository;
import org.springsource.samples.model.Itinerary;

@Controller
public class TravelService {

	private final ItineraryRepository itineraryRepository;

	@Autowired
	public TravelService(ItineraryRepository itineraryRepository) {
		this.itineraryRepository = itineraryRepository;
	}

	public List<Itinerary> getItinerariesForUser(String username) {
		return this.itineraryRepository.find(username);
	}

	public String addItinerary(Itinerary itinerary) {
		return this.itineraryRepository.add(itinerary);
	}

}
