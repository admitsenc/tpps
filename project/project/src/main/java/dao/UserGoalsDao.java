package project;

public interface UserGoalsDao {
	public List<UserGoals> getUserGoalsList(int userId, int o, int limit);
	public List<UserGoals> getUserGoalsByStatus(int userId, String status);
	public UserGoals saveUserGoal(User user, Goals goal) throws ApplicationException;
	public void updateUserGoal(int userGoalId, String status) throws ApplicationException;
	public void deleteUserGoal(int userGoalId) throws ApplicationException;

}
