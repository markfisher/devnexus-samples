package org.springsource.samples.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springsource.samples.model.FlightReservation;

@Repository
public class FlightReservationRepository implements ReservationRepository<FlightReservation> {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final FlightReservationRowMapper mapper = new FlightReservationRowMapper();

	@Autowired
	public FlightReservationRepository(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void add(final FlightReservation reservation, String itineraryId) {
		String sql = "insert into flight_reservations (itinerary_id, seat_number, flight_number) values (?,?,?)";
		this.jdbcTemplate.getJdbcOperations().update(sql,
				Integer.parseInt(itineraryId),
				reservation.getSeatNumber(),
				reservation.getFlightNumber());
	}

	public FlightReservation find(String itineraryId) {
		String sql = "select * from flight_reservations where itinerary_id=?";
		return this.jdbcTemplate.getJdbcOperations().queryForObject(sql, mapper, itineraryId);
	}

	private static class FlightReservationRowMapper implements RowMapper<FlightReservation> {
		public FlightReservation mapRow(ResultSet rs, int rowNum) throws SQLException {
			FlightReservation reservation = new FlightReservation();
			reservation.setSeatNumber(rs.getString("seat_number"));
			reservation.setFlightNumber(rs.getString("flight_number"));
			return reservation;
		}
	}

}
