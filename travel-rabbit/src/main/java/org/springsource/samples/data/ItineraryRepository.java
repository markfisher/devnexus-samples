package org.springsource.samples.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springsource.samples.model.Itinerary;

@Repository
public class ItineraryRepository {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public ItineraryRepository(MongoDbFactory mongoDbFactory) {
		this.mongoTemplate = new MongoTemplate(mongoDbFactory);
	}

	public String add(final Itinerary itinerary) {
		this.mongoTemplate.insert(itinerary);
		return itinerary.getId();
	}

	public List<Itinerary> find(String username) {
		return this.mongoTemplate.find(Query.query(Criteria.where("username").is(username)), Itinerary.class);
	}
}
