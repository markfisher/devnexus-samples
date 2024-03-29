package org.springsource.samples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springsource.samples.data.ItineraryRepository;
import org.springsource.samples.model.Itinerary;

@Service
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

	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("META-INF/context.xml");
	}
}
