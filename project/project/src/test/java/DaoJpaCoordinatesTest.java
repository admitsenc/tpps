package project;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DaoJpaCoordinatesTest {
	JpaCoordinatesDao coordDao;
User user;
Workout workout;
@Before
public void initTest() throws ApplicationException{
	coordDao = new JpaCoordinatesDao();
	JpaUserDao userDao = new JpaUserDao();
	user = userDao.getUserByLogin("test@test");
	List<Workout> wList = user.getWorkouts();
	workout = wList.iterator().next();
}
@Test
public void testGetCoordinatesList() {
	//getCoordinatesList is not implemented yet
	assertNull(coordDao.getCoordinatesList(workout.getId()));
}
@Test 
public void testSaveCoordinateList() throws ApplicationException {
	//not implemented yet
	fail("not implemented yet");
}
@Test
public void testSaveCoordinate() {
	float latitude = (float)30;
	float longitude = (float)50;
	int sizeBefore = workout.getCoordinates().size();
	coordDao.saveCoordinate(latitude, longitude, workout);
	int sizeAfter = workout.getCoordinates().size();
	assertTrue(sizeBefore != sizeAfter);
	assertTrue(sizeBefore+1 == sizeAfter);
}
@Test
public void testDeleteCoordinates() throws ApplicationException {
	List<Coordinates> coordList = workout.getCoordinates();
	int size = coordList.size();
	Coordinates c = coordList.iterator().next();
	int id = c.getId();
	coordDao.deleteCoordinates(id);
}
