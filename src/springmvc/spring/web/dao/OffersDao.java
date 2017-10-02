package springmvc.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("offersDao")
public class OffersDao {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {
		return jdbc.query("SELECT * FROM offers", new RowMapper<Offer>() {
			
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User(); 
				user.setAuthority(rs.getString("authority"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setEnabled(true);
				user.setUsername(rs.getString("username"));
				
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setText(rs.getString("text"));
				offer.setUser(user);
				return offer;
			}

		});
	}
	public Offer getOfferById(int id) {

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);

		return jdbc.queryForObject("SELECT * FROM offers, users where offers.name=users.username and users.enabled=true", param, new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User(); 
				user.setAuthority(rs.getString("authority"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setEnabled(true);
				user.setUsername(rs.getString("username"));
				
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setText(rs.getString("text"));
				offer.setUser(user);
				return offer;
			}
		});
	}

	public boolean deleteOfferById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("DELETE FROM offers WHERE id=:id", params) == 1;
	}

	public boolean createOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("INSERT INTO offers (name, text) values (:name, :text)", params) == 1;

	}

	public boolean updateOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("UPDATE offers set text=:text WHERE id=:id", params) == 1;
	}
	@Transactional
	public int[] createOffer(List<Offer> offers) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("INSERT INTO offers (username, text) VALUES (:username, :text)", params);

	}
}