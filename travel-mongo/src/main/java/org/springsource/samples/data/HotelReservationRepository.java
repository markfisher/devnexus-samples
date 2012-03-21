package org.springsource.samples.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;
import org.springsource.samples.model.HotelReservation;

@Repository
public class HotelReservationRepository extends AbstractReservationRepository<HotelReservation> {

	@Autowired
	public HotelReservationRepository(MongoDbFactory mongoDbFactory) {
		super(mongoDbFactory, HotelReservation.class);
	}
}
