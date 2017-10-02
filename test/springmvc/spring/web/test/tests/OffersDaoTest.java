package springmvc.spring.web.test.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springmvc.spring.web.dao.Offer;
import springmvc.spring.web.dao.OffersDao;
import springmvc.spring.web.dao.User;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:springmvc/spring/web/config/security-context.xml",
		"classpath:springmvc/spring/web/config/dao-context.xml",
		"classpath:springmvc/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OffersDaoTest {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private OffersDao offersDao;

	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("DELETE FROM users");
		jdbc.execute("DELETE FROM offers");
	}
	
	@Test
	public void testCreateOffer() {
		User user = new User("test", "testname", "password", "mail@test.com", "ROLE_USER", true);
		Offer offer = new Offer(user , "test text"); 
		assertTrue("Offer creation should return true",  offersDao.createOffer(offer));
		List<Offer> offers = offersDao.getOffers();
		assertEquals("Should be one offer in database", 1, offers.size());
		assertEquals("Retrieved offer should match created offer", offer, offers.get(0));
		
	}
}
