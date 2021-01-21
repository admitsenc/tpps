import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class BeansGoalsTest {
	Goals testGoal;
	@Before
	public void initTest(){
		testGoal = new Goals();
	}
	@Test
	public void testGetId() {
		assertTrue(0 == testGoal.getId());
	}
	@Test
	public void testSetId() {
		int result = 2;
		testGoal.setId(2);
		
		assertTrue(result == testGoal.getId());
	}
	@Test
	public void testGoalsConstructor() {
		testGoal = new Goals();
		assertNotNull(testGoal);
		assertTrue(0 == testGoal.getId());
		assertTrue(0 == testGoal.getDistance());
		assertNull(testGoal.getDescription());
	}
	@Test
	public void testGoalsIntIntStringConstructor() {
		testGoal = new Goals(2, 30, "30 km");

		assertTrue(2 == testGoal.getId());
		assertTrue(30 == testGoal.getDistance());
		assertTrue("30 km" == testGoal.getDescription());
	}
	@Test
	public void testGetDistance() {
		assertTrue(0 == testGoal.getDistance());
	}
	@Test
	public void testSetDistance() {
		double expected = 10.456;
		testGoal.setDistance(expected);
		
		double result = testGoal.getDistance();

		assertTrue(expected == result);
	}
	@Test
	public void testGetDescription() {
		assertNull(testGoal.getDescription());
	}
	@Test
	public void testSetDescription() {
		String expected = "marathon";
		testGoal.setDescription("marathon");
		
		assertEquals(expected, testGoal.getDescription());
	}
	@Test
	public void testGetUserGoals() {
		assertNull(testGoal.getUserGoals());	
	}
	@Test
	public void testSetUserGoals() {
		List<UserGoals> userGoals = new ArrayList<UserGoals>();
		assertNull(testGoal.getUserGoals());
		testGoal.setUserGoals(userGoals);
		assertNotNull(testGoal.getUserGoals());}}
