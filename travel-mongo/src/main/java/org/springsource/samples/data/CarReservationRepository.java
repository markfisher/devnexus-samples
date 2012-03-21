package org.springsource.samples.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;
import org.springsource.samples.model.CarReservation;

@Repository
public class CarReservationRepository extends AbstractReservationRepository<CarReservation> {

	@Autowired
	public CarReservationRepository(MongoDbFactory mongoDbFactory) {
		super(mongoDbFactory, CarReservation.class);
	}
}
