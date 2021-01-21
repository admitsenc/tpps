import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DaoJpaUserTest {
	JpaUserDao userDao;
	int id;
	User user;
	@Before
	public void initTest() throws ApplicationException{
		userDao = new JpaUserDao();
		user = userDao.registerUser("testUnit", "testUnit", "testUnit", "testUnit");
	}
	@After
	public void cleanUpTest() throws ApplicationException{
		user = userDao.getUserByLogin("testUnit");
		userDao.deleteUser(user.getId());
	}
	@Test
	public void testRegisterUser(){
		assertNotNull(user);
	}
	@Test
	public void testGetUserByLogin() throws ApplicationException {
		user = userDao.getUserByLogin("testUnit");
		assertTrue("testUnit" == user.getFirstName());
		assertNotNull(user);
	}
	@Test
	public void testGetUserById() throws ApplicationException {
		id = user.getId();
		user = userDao.getUserById(id);
		assertTrue("testUnit" == user.getFirstName());
		assertNotNull(user);
	}
	@Test
	public void testLogin() throws ApplicationException {
		user = userDao.login("testUnit", "testUnit");
		assertTrue("testUnit" == user.getFirstName());
		assertNotNull(user);
	}
	@Test
	public void testUpdateUser() throws ApplicationException {
		user = userDao.getUserByLogin("testUnit");
		user.setFirstName("updateUser");
		User user2 = userDao.updateUser(user);
		assertNotNull(user2);
		assertEquals("updateUser", user2.getFirstName());
	}
	@Test
	public void testDeleteUser() throws ApplicationException {
		id = user.getId();
		userDao.deleteUser(id);
		//check that element is deleted without getting ApplicationException 
		List<User> list = userDao.getUserList();
		user = list.get(list.size()-1);
		assertTrue(id != user.getId());
		//initializing new user for cleanup method
		user = userDao.registerUser("testUnit", "testUnit", "testUnit", "testUnit");
	}
	@Test
	public void testGetUserRoleByRoleName() throws ApplicationException {
		Roles role = userDao.getUserRoleByRoleName("REGULAR");
		assertTrue(3  == role.getId());
		assertEquals("REGULAR", role.getName());
		assertNotNull(role);
	}
	@Test
	public void testGetUserList() throws ApplicationException {
		List<User> list = userDao.getUserList();
		assertNotNull(list);
		assertTrue(0 <= list.size());
	}}
