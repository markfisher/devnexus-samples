package org.springsource.samples.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;
import org.springsource.samples.model.FlightReservation;

@Repository
public class FlightReservationRepository extends AbstractReservationRepository<FlightReservation> {

	@Autowired
	public FlightReservationRepository(MongoDbFactory mongoDbFactory) {
		super(mongoDbFactory, FlightReservation.class);
	}
}
