package org.springsource.samples.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springsource.samples.model.CarReservation;
import org.springsource.samples.model.FlightReservation;
import org.springsource.samples.model.HotelReservation;
import org.springsource.samples.model.Itinerary;
import org.springsource.samples.service.TravelService;

@Controller
public class TravelController {
	
	private static final Logger logger = LoggerFactory.getLogger(TravelController.class);

	private final TravelService travelService;

	@Autowired
	public TravelController(TravelService travelService) {
		this.travelService = travelService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("home");
		model.addAttribute("itineraries", travelService.getItinerariesForUser("joe"));
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam String zip, @RequestParam String startDate, @RequestParam String endDate, Model model) {
		logger.info("searching: zip=" + zip + ", start=" + startDate + ", end=" + endDate);
		model.addAttribute("zip", zip);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		return "search";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String book(@RequestParam String username,
			@RequestParam String startDate,
			@RequestParam String endDate,
			@RequestParam String flightNumber,
			@RequestParam String seatNumber,
			@RequestParam String hotelName,
			@RequestParam String roomNumber,
			@RequestParam String carSize,
			@RequestParam String rentalAgency,
			Model model) {
		logger.info("booking: flight=" + flightNumber + ", hotel=" + hotelName + ", car=" + rentalAgency);
		Itinerary itinerary = new Itinerary();
		itinerary.setUsername(username);
		itinerary.setStartDate(startDate);
		itinerary.setEndDate(endDate);
		FlightReservation flightReservation = new FlightReservation();
		flightReservation.setFlightNumber(flightNumber);
		flightReservation.setSeatNumber(seatNumber);
		itinerary.setFlightReservation(flightReservation);
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.setHotelName(hotelName);
		hotelReservation.setRoomNumber(roomNumber);
		itinerary.setHotelReservation(hotelReservation);
		CarReservation carReservation = new CarReservation();
		carReservation.setCarSize(carSize);
		carReservation.setRentalAgency(rentalAgency);
		itinerary.setCarReservation(carReservation);
		travelService.addItinerary(itinerary);
		return "redirect:/";
	}

}
