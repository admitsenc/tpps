package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class DaoJpaWorkoutTest {
	JpaWorkoutDao workoutDao ;
	User user;
	@Before
	public void initTest() throws ApplicationException{
		workoutDao = new JpaWorkoutDao();
		JpaUserDao userDao= new JpaUserDao();
		user = userDao.getUserByLogin("test@test");
	}
	@Test
	public void testJpaWorkoutDao() {
		assertNotNull(workoutDao);
	}
	@Test
	public void testGetWorkoutList() throws ApplicationException {
		List<Workout> workoutList = 
				workoutDao.getWorkoutList(user.getId(), 5, 10);
		assertNotNull(workoutList);
		assertTrue(0 == workoutList.size());
	}
	@Test
	public void testSaveWorkout() throws ApplicationException {
		Workout workout = new Workout();
		workout.setDistanse(22000);
		workout.setUser(user);
		Workout result = workoutDao.saveWorkout(workout);
		assertEquals(result, workout);
		workoutDao.deleteWorkout(result.getId());
	}
	@Test
	public void testDeleteWorkout() throws ApplicationException {
		//change after, getworkoutlist shows nothing 
		Workout workout = new Workout();
		workout.setDistanse(22000);
		workout.setUser(user);
		Workout result = workoutDao.saveWorkout(workout);
		workoutDao.deleteWorkout(result.getId());
	}}
