public interface DaoFactory {
	public UserDao createUserDao();
	public WorkoutDao createWorkoutDao();
	public CoordinatesDao createCoordinatesDao(); 
	public GoalsDao createGoalsDao();
	public UserGoalsDao createUserGoalsDao();
}
