package org.springsource.samples.data;

public interface ReservationRepository<R> {

	void add(R reservation);

	R find(String itineraryId);

}
