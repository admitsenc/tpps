public interface GoalsDao {
	public List<Goals> getGoalsList();
	public Goals getGoalById(int goalId) throws ApplicationException;
	public Goals saveGoal(double distance, String name) throws ApplicationException;
	public void updateGoal(int goalId, double distance, String description) throws ApplicationException;
	public void deleteGoal(int goalId) throws ApplicationException;

}
