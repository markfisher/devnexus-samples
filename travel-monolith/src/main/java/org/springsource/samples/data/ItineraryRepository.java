package org.springsource.samples.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springsource.samples.model.Itinerary;

@Repository
public class ItineraryRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final ItineraryRowMapper mapper = new ItineraryRowMapper();

	@Autowired
	public ItineraryRepository(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public String add(final Itinerary itinerary) {
		final String sql = "insert into itineraries (username, startDate, endDate) values (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"ID"});
				ps.setString(1, itinerary.getUsername());
				ps.setString(2, itinerary.getStartDate());
				ps.setString(3, itinerary.getEndDate());
				return ps;
			}
		};
		this.jdbcTemplate.getJdbcOperations().update(creator, keyHolder);
		//this.jdbcTemplate.getJdbcOperations().update(sql,
			//	itinerary.getUsername(),
				//itinerary.getStartDate(),
				//itinerary.getEndDate());
		return "" + keyHolder.getKey();
	}

	public List<Itinerary> find(String username) {
		String sql = "select * from itineraries where username=?";
		return this.jdbcTemplate.getJdbcOperations().query(sql, mapper, username);
	}

	private static class ItineraryRowMapper implements RowMapper<Itinerary> {
		public Itinerary mapRow(ResultSet rs, int rowNum) throws SQLException {
			Itinerary itinerary = new Itinerary(rs.getString("id"));
			itinerary.setUsername(rs.getString("username"));
			itinerary.setStartDate(rs.getString("startDate"));
			itinerary.setEndDate(rs.getString("endDate"));
			return itinerary;
		}
	}

}
