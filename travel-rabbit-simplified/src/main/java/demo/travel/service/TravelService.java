package demo.travel.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import demo.travel.model.Itinerary;
import demo.travel.model.Reward;

@Service
public class TravelService {

	public Reward generateReward(Itinerary itinerary) {
		Reward reward = new Reward();
		reward.setUsername(itinerary.getUsername());
		int points = 0;
		if (itinerary.getFlightReservation() != null) {
			points += 500;
		}
		if (itinerary.getHotelReservation() != null) {
			points += 250;
		}
		if (itinerary.getCarReservation() != null) {
			points += 75;
		}
		reward.setPoints(points);
		System.out.println("generated " + reward.getPoints() + " point reward for " + reward.getUsername());
		return reward;
	}

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("META-INF/context.xml");
	}
}
