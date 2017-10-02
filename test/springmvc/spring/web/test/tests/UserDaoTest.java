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
import springmvc.spring.web.dao.User;
import springmvc.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:springmvc/spring/web/config/security-context.xml",
		"classpath:springmvc/spring/web/config/dao-context.xml",
		"classpath:springmvc/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("DELETE FROM users");
		jdbc.execute("DELETE FROM offers");
	}
	@Test
	public void testCreateUser() {
		User user = new User("test", "testname", "password", "mail@test.com", "ROLE_USER", true);
		assertTrue("User creation should return true", usersDao.createUser(user));
		List<User> users = usersDao.getAllUsers();
		assertEquals("Should be one user in database", 1, users.size());

	}
}
