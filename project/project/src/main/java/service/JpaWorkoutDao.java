import java.util.List;

public class JpaWorkoutDao extends JpaBase implements WorkoutDao {
	public JpaWorkoutDao() {}
@Override
	public List<Workout> getWorkoutList(int userId, int offset, int limit) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager();
			Query query = entitymanager.createNamedQuery("Workout.getWorkoutList").setFirstResult(offset).setMaxResults(limit);
		query.setParameter("user_id", userId);
		List<Workout> workoutList = (List<Workout>)query.getResultList();
		if (workoutList == null){
			throw new ApplicationException();
		}
		return workoutList;	}
@Override
	public Workout saveWorkout(Workout workout) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(workout);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return workout;	}
	@Override
	public void deleteWorkout(int workoutId) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Workout workout = entitymanager.find(Workout.class, workoutId);
		if (workout == null)
			throw new ApplicationException();
		
		for (Coordinates coord : workout.getCoordinates()) {
			entitymanager.remove(coord);
		}
		entitymanager.remove(workout);
		entitymanager.getTransaction().commit();
		entitymanager.close();}}	

