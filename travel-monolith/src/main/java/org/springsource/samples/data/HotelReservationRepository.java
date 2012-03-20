package org.springsource.samples.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springsource.samples.model.HotelReservation;

@Repository
public class HotelReservationRepository implements ReservationRepository<HotelReservation> {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final HotelReservationRowMapper mapper = new HotelReservationRowMapper();

	@Autowired
	public HotelReservationRepository(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void add(final HotelReservation reservation, String itineraryId) {
		String sql = "insert into hotel_reservations (itinerary_id, room_number, hotel_name) values (?,?,?)";
		this.jdbcTemplate.getJdbcOperations().update(sql,
				Integer.parseInt(itineraryId),
				reservation.getRoomNumber(),
				reservation.getHotelName());
	}

	public HotelReservation find(String itineraryId) {
		String sql = "select * from hotel_reservations where itinerary_id=?";
		return this.jdbcTemplate.getJdbcOperations().queryForObject(sql, mapper, itineraryId);
	}

	private static class HotelReservationRowMapper implements RowMapper<HotelReservation> {
		public HotelReservation mapRow(ResultSet rs, int rowNum) throws SQLException {
			HotelReservation reservation = new HotelReservation();
			reservation.setRoomNumber(rs.getString("room_number"));
			reservation.setHotelName(rs.getString("hotel_name"));
			return reservation;
		}
	}

}
