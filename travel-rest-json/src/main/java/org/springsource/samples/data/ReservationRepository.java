package org.springsource.samples.data;

public interface ReservationRepository<R> {

	void add(R reservation, String itineraryId);

	R find(String itineraryId);

}
