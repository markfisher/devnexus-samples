package org.springsource.samples.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springsource.samples.model.Itinerary;
import org.springsource.samples.service.TravelService;

@Controller
@RequestMapping(produces="application/json")
public class TravelController {
	
	private static final Logger logger = LoggerFactory.getLogger(TravelController.class);

	private final TravelService travelService;

	@Autowired
	public TravelController(TravelService travelService) {
		this.travelService = travelService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody public List<Itinerary> home() {
		return travelService.getItinerariesForUser("joe");
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody public Map<String,?> search(@RequestBody Map<String, String> map) {
		logger.info("searching: " + map);
		Map<String, Object> results = new HashMap<String, Object>(map);
		Map<String, String> flights = new HashMap<String, String>();
		flights.put("FC123", "First Class Airlines: 123");
		flights.put("CC456", "Cramped Cabin Air: 456");
		results.put("flights", flights);	
		results.put("seats", new String[] {"1A", "37E"});
		results.put("hotels", new String[] {"Cheap Inn", "Luxury Suites", "Roach Motel"});
		results.put("rooms", new String[] {"103", "1207"});
		results.put("carSizes", new String[] {"economy", "compact", "intermediate", "luxury"});
		results.put("rentalAgencies", new String[] {"Lemons R'Us", "Quality Cars"});
		return results;
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	@ResponseBody
	public Itinerary book(@RequestBody Itinerary itinerary) {
/* EXAMPLE		 
{"username":"joe", "startDate":"04/01/12", "endDate":"04/09/12",
    "flightReservation": {"flightNumber":"AB123", "seatNumber":"1A"},
    "hotelReservation": {"hotelName":"Roach Motel", "roomNumber":"1207"},
    "carReservation": {"carSize":"compact", "rentalAgency":"Quality Cars"}
}
*/ 
		logger.info("booking: flight=" + itinerary.getFlightReservation() +
				", hotel=" + itinerary.getHotelReservation() +
				", car=" + itinerary.getCarReservation());
		String id = travelService.addItinerary(itinerary);
		itinerary.setId(id);
		return itinerary;
	}

}
