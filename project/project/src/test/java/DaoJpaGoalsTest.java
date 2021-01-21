package project;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DaoJpaGoalsTest {
	JpaGoalsDao goalsDao;
		public int getLastId(List<Goals> list){
		List<Goals> goalsList = goalsDao.getGoalsList();
		int lastId = 0;
		for (Goals g : goalsList){
			lastId = g.getId();
		}
		return lastId;
	}
	@Before
	public void initTest(){
		goalsDao = new JpaGoalsDao();
	}
	@Test
	public void testJpaGoalsDao() {
		assertNotNull(goalsDao);
	}
@Test
	public void testGetGoalsList() {
		List<Goals> goalsList =  goalsDao.getGoalsList();
		assertNotNull(goalsList);
	}
	@Test
	public void testGetGoalById() throws ApplicationException {
		assertNotNull(goalsDao.getGoalById(1));
	}
	@Test
	public void testSaveGoal() throws ApplicationException{
		goalsDao.saveGoal(1000, "thousand");
		List<Goals> goalsList =  goalsDao.getGoalsList();
		assertNotNull(goalsList);
		int lastId = goalsList.size() -1;
		double result = goalsList.get(lastId).getDistance();
		assertTrue(1000.0 == result);
	}
	@Test
	public void testUpdateGoal() {
		List<Goals> goalsList = goalsDao.getGoalsList();
		assertNotNull(goalsList);
	}
	@Test
	public void testDeleteGoal() throws ApplicationException {
		List<Goals> goalsList = goalsDao.getGoalsList();
		int sizeBefore = goalsList.size() -1;
		int lastId = getLastId(goalsList);
		goalsDao.deleteGoal(lastId);
		int sizeAfter = goalsDao.getGoalsList().size();
		assertTrue(sizeBefore == sizeAfter);
	}}
