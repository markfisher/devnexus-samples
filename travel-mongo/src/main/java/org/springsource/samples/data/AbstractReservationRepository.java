package org.springsource.samples.data;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class AbstractReservationRepository<R> implements ReservationRepository<R> {

	private final MongoTemplate mongoTemplate;
	private final Class<R> type;

	AbstractReservationRepository(MongoDbFactory mongoDbFactory, Class<R> type) {
		this.mongoTemplate = new MongoTemplate(mongoDbFactory);
		this.type = type;
	}

	public void add(final R reservation) {
		this.mongoTemplate.insert(reservation);
	}

	public R find(String itineraryId) {
		return this.mongoTemplate.findOne(Query.query(Criteria.where("itineraryId").is(itineraryId)), type);
	}

}
