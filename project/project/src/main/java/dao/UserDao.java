package project;

public interface UserDao {
	public User registerUser(String email, String password, String firstName, String lastName) throws ApplicationException;
	public User getUserByLogin(String login) throws ApplicationException;
	public User getUserById(int userId) throws ApplicationException;
	public Roles getUserRoleByRoleName(String roleName) throws ApplicationException;
	public User login(String email, String password) throws ApplicationException;
	public User updateUser(User user) throws ApplicationException;
	public void deleteUser(int userId)throws ApplicationException;
	public List<User> getUserList()throws ApplicationException;

}
