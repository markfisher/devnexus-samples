package org.springsource.samples.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springsource.samples.model.CarReservation;

@Repository
public class CarReservationRepository implements ReservationRepository<CarReservation> {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final CarReservationRowMapper mapper = new CarReservationRowMapper();

	@Autowired
	public CarReservationRepository(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void add(final CarReservation reservation, String itineraryId) {
		String sql = "insert into car_reservations (itinerary_id, car_size, rental_agency) values (?,?,?)";
		this.jdbcTemplate.getJdbcOperations().update(sql,
				Integer.parseInt(itineraryId),
				reservation.getCarSize(),
				reservation.getRentalAgency());
	}

	public CarReservation find(String itineraryId) {
		String sql = "select * from car_reservations where itinerary_id=?";
		return this.jdbcTemplate.getJdbcOperations().queryForObject(sql, mapper, itineraryId);
	}

	private static class CarReservationRowMapper implements RowMapper<CarReservation> {
		public CarReservation mapRow(ResultSet rs, int rowNum) throws SQLException {
			CarReservation reservation = new CarReservation();
			reservation.setCarSize(rs.getString("car_size"));
			reservation.setRentalAgency(rs.getString("rental_agency"));
			return reservation;
		}
	}

}
