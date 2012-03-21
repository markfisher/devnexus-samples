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
		reward.setPoints(500); // determine from the itinerary
		System.out.println("generated " + reward.getPoints() + " point reward for " + reward.getUsername());
		return reward;
	}

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("META-INF/context.xml");
	}
}
