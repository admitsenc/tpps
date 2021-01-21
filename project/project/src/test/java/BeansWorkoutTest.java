package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BeansWorkoutTest {
	Workout testWorkout;
	@Before 
	public void initTest(){
		testWorkout = new Workout();
	}
	@Test
	public void testGetId() {
		assertTrue ( 0 == testWorkout.getId());
	}
	@Test
	public void testWorkout() {
		assertNotNull(testWorkout);
	}
	@Test
	public void testWorkoutIntUserStringDoubleLong() {
		User helpuser = new User();
		helpuser.setId(40);
		testWorkout = new Workout(3, helpuser, "123", 34.567, 123456789);

		assertNotNull(testWorkout);
		assertTrue(3 == testWorkout.getId());
		assertNotNull(testWorkout.getUser());
		assertTrue(40 == testWorkout.getUser().getId());
		assertEquals("123", testWorkout.getDuration());
		assertTrue(34.567 == testWorkout.getDistanse());
		assertTrue(123456789 == testWorkout.getDate());
	}
	@Test
	public void testSetId() {
		testWorkout.setId(3);
		assertTrue(3 == testWorkout.getId());
	}
	@Test
	public void testGetDuration() {
		assertNull(testWorkout.getDuration());
	}
	@Test
	public void testSetDuration() {
		testWorkout.setDuration("123");
		assertEquals("123", testWorkout.getDuration());
	}
	@Test
	public void testGetDistanse() {
		assertTrue(0 == testWorkout.getDistanse());
	}
	@Test
	public void testSetDistanse() {
		testWorkout.setDistanse(34.567);
		assertTrue(34.567 == testWorkout.getDistanse());
	}
	@Test
	public void testGetDate() {
		assertTrue(0 == testWorkout.getDate());
	}
	@Test
	public void testSetDate() {
		testWorkout.setDate(123456789);
		assertTrue(123456789 == testWorkout.getDate());
	}
	@Test
	public void testGetUser() {
		assertNull(testWorkout.getUser());
	}
	@Test
	public void testSetUser() {
		User helpUser = new User();
		helpUser.setId(45);
		testWorkout.setUser(helpUser);

		assertNotNull(testWorkout.getUser());
		assertTrue(45 == testWorkout.getUser().getId());		
	}
	@Test
	public void testGetCoordinates() {
		assertNotNull(testWorkout.getCoordinates());
		assertTrue(0 == testWorkout.getCoordinates().size());
	}
	@Test
	public void testAddToCoordinates() {
		Coordinates coord = new Coordinates();
		coord.setId(2);
		coord.setLatitude((float)51.3462);
		coord.setLongitude((float)31.3522);
		testWorkout.addToCoordinates(coord);

		assertTrue(1 == testWorkout.getCoordinates().size());
		assertTrue(testWorkout.getCoordinates().contains(coord));
	}
	@Test
	public void testRemoveFromCoordinates() {
		Coordinates coord = new Coordinates();
		coord.setId(2);
		coord.setLatitude((float)51.3462);
		coord.setLongitude((float)31.3522);
		testWorkout.addToCoordinates(coord);

		assertTrue(1 == testWorkout.getCoordinates().size());
		assertTrue(testWorkout.getCoordinates().contains(coord));
		
		testWorkout.removeFromCoordinates(coord);
		assertTrue(0 == testWorkout.getCoordinates().size());
		assertFalse(testWorkout.getCoordinates().contains(coord));
	}}
