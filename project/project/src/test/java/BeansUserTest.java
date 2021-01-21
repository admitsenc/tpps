package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BeansUserTest {
	User testUser;
	@Before 
	public void initTest(){
		testUser = new User();
	}	
	@Test
	public void testGetId() {
		assertTrue(0 == testUser.getId());
	}
	@Test
	public void testUser() {
		assertNotNull(testUser);
	}
	@Test
	public void testUserIntStringStringStringStringRoles() {
		Roles helpRole = new Roles(2,"admin");
		testUser = new User(5, "1@1", "1234", "Ala", "Aba", helpRole);
		
		assertNotNull(testUser);
		assertTrue(5 == testUser.getId());
		assertEquals("1@1", testUser.getEmail());
		assertEquals("1234", testUser.getPassword());
		assertEquals("Ala", testUser.getFirstName());
		assertEquals("Aba", testUser.getLastName());
		assertNotNull(testUser.getUserRole());
		assertTrue(2 == testUser.getUserRole().getId());
	}
	@Test
	public void testSetId() {
		testUser.setId(6);
		assertTrue(6 == testUser.getId());
	}
	@Test
	public void testGetEmail() {
		assertNull(testUser.getEmail());
	}
	@Test
	public void testSetEmail() {
		String email = "ala@aba.com";
		testUser.setEmail(email);
		assertEquals(email, testUser.getEmail());
	}
	@Test
	public void testGetPassword() {
		assertNull(testUser.getPassword());
	}
	@Test
	public void testSetPassword() {
		String pass = "qwerty";
		testUser.setPassword(pass);
		assertEquals(pass, testUser.getPassword());
	}
	@Test
	public void testGetFirstName() {
		assertNull(testUser.getFirstName());
	}
	@Test
	public void testSetFirstName() {
		String firstName = "Ala";
		testUser.setFirstName(firstName);
		assertEquals(firstName, testUser.getFirstName());
	}
	@Test
	public void testGetLastName() {
		assertNull(testUser.getLastName());
	}
	@Test
	public void testSetLastName() {
		String lastName = "aba";
		testUser.setLastName(lastName);
		assertEquals(lastName, testUser.getLastName());
	}
	@Test
	public void testGetUserRole() {
		assertNull(testUser.getUserRole());
	}
	@Test
	public void testSetUserRole() {
		Roles helpRole =  new Roles();
		helpRole.setId(12);
		testUser.setUserRole(helpRole);
		assertTrue(12 == testUser.getUserRole().getId());
	}
	@Test
	public void testGetUserGoals() {
		assertNull(testUser.getUserGoals());
	}
	@Test
	public void testSetUserGoals() {
		List<UserGoals> userGoals = new ArrayList<UserGoals>();
		assertNull(testUser.getUserGoals());
		testUser.setUserGoals(userGoals);
		assertNotNull(testUser.getUserGoals());
	}
	@Test
	public void testGetWorkouts() {
		assertNull(testUser.getWorkouts());
	}
	@Test
	public void testSetWorkouts() {
		List<Workout> workoutHelper = new ArrayList<Workout>();
		assertNull(testUser.getWorkouts());
		testUser.setWorkouts(workoutHelper);
		assertNotNull(testUser.getWorkouts());
	}}

