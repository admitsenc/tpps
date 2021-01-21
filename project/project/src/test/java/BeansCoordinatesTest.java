import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BeansCoordinatesTest {
	Coordinates testCoordinate;
	
	@Before
	public void initTest(){
		testCoordinate = new Coordinates();
	}
	@Test
	public void testGetId() {
		assertEquals(0, testCoordinate.getId());
	}	
	@Test
	public void testGetIdNotNull() {
		assertNotNull(testCoordinate.getId());
	}
	@Test
	public void testSetId() {
		testCoordinate.setId(4);
		int resultId = testCoordinate.getId();
		assertEquals(4, resultId);
	}
	@Test
	public void testSetLongitude() {
		testCoordinate.setLongitude((float) 51.68);
		float expected = (float) 51.68;
		float result = testCoordinate.getLongitude();
		assertTrue(	expected == result);
	}
	@Test
	public void testGetLongitude() {
		assertTrue(	0 == testCoordinate.getLongitude());
	}
	@Test
	public void testGetLatitude() {
		assertTrue(0 == testCoordinate.getLatitude());
	}
	@Test
	public void testSetLatitude() {
		testCoordinate.setLatitude((float) 51.681);
		float expected = (float) 51.681;
		float result = testCoordinate.getLatitude();
		assertTrue(	expected == result);
	}
	@Test
	public void testGetWorkout() {
		assertNull(testCoordinate.getWorkout());
	}
	@Test
	public void testSetWorkout() {
		Workout helperWorkout = new Workout();
		helperWorkout.setId(2);
		
		testCoordinate.setWorkout(helperWorkout);
		int result = 
				testCoordinate
				.getWorkout()
				.getId();
		assertTrue(2 == result);
	}}
