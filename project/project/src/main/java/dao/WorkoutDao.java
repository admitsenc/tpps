public interface WorkoutDao {
	public List<Workout> getWorkoutList(int userId, int offset, int limit) throws ApplicationException;
	public Workout saveWorkout(Workout workout) throws ApplicationException;
	public void deleteWorkout(int workoutId) throws ApplicationException;

}
