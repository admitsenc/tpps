import java.util.List;

public class JpaCoordinatesDao extends JpaBase implements CoordinatesDao {
	@Override
	public List<Coordinates> getCoordinatesList(int WorkoutId) {
		return null;
	}
	@Override
	public void saveCoordinateList(List<Coordinates> coord) throws ApplicationException {
	}
	@Override
	public void saveCoordinate(float latitude, float longitude, Workout workout) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Coordinates coord = new Coordinates();
	    coord.setLatitude(latitude);
	    coord.setLongitude(longitude);
		coord.setWorkout(workout);
		workout.getCoordinates().add(coord);
		entitymanager.persist(coord);
	  	entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	@Override
	public void deleteCoordinates(int coordinateId) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Coordinates coord = entitymanager.find(Coordinates.class, coordinateId);
		entitymanager.remove(coord);
				
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}}
