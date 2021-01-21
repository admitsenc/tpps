package project;

import java.util.List;

public class JpaGoalsDao extends JpaBase implements GoalsDao {
	public JpaGoalsDao() {}
	@Override
	public List<Goals> getGoalsList() {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		List<Goals> listGoals = entitymanager.createQuery("SELECT g FROM Goals g").getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return listGoals;
	}
	public Goals getGoalById(int goalId) throws ApplicationException{
		EntityManager entitymanager = emfactory.createEntityManager();
		Goals g = entitymanager.find( Goals.class, goalId );
		
		if (g == null) {
			entitymanager.close();
			throw new ApplicationException();
		}
		entitymanager.close();
				
		return g;
	}
	@Override
	public Goals saveGoal(double distance, String description) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Goals goal = new Goals(); 
		goal.setDistance(distance);
		goal.setDescription(description);
		
		entitymanager.persist(goal);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
		if (!(goal.getId() > 0))
			throw new ApplicationException();
		return goal;
	}
	@Override
	public void updateGoal(int goalId, double distance, String description) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Goals goal = entitymanager.find( Goals.class, goalId);
		if (goal == null ){
			entitymanager.close();
			throw new ApplicationException();
		}
		goal.setDistance(distance);
		goal.setDescription(description);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}	
	@Override
	public void deleteGoal(int goalId)throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Goals goal = entitymanager.find( Goals.class, goalId);
		if (goal == null ){
			entitymanager.close();
			throw new ApplicationException();
		}
		for (UserGoals userGoals : goal.getUserGoals()) {
			entitymanager.remove(userGoals);
		}
		entitymanager.remove(goal);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}}
