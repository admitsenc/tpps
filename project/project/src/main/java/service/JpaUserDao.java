import java.util.List;

import javax.management.Query;

public class JpaUserDao extends JpaBase implements UserDao {
	@Override
	public User registerUser(String email, String password, String firstName, String lastName)
			throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		User user = new User(); 
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		Roles role = getUserRoleByRoleName("REGULAR");
		user.setUserRole(role);
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return user;
	}
@Override
	public User getUserByLogin(String login) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("User.getUserByLogin");
		query.setParameter("email", login);
		List<User> userList = query.getResultList();
		User user = null;
		if (userList != null && userList.size() > 0) {
			user = userList.get(0);
		}else{
			throw new ApplicationException();
		} 
		entitymanager.close();
		return user;
	}
	@Override
	public User getUserById(int userId) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager();
		User user = entitymanager.find( User.class, userId );
		if (user == null) {
			entitymanager.close();
			throw new ApplicationException();
		}
		entitymanager.close();
		return user;
	}
	@Override
	public User login(String email, String password) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("User.login");
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = (User)query.getSingleResult();
		entitymanager.close();
		if (user == null){
			throw new ApplicationException();
		}
		return user;
	}
	
	@Override
	public User updateUser(User user) throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction().begin();
		User updatedUser = entitymanager.find( User.class, user.getId() );
		if (updatedUser == null )
			throw new ApplicationException();
		if (user.getUserRole().getId() == 0){
			Roles role = (!user.getUserRole().getName().equals(updatedUser.getUserRole().getName())) ? 
						getUserRoleByRoleName(user.getUserRole().getName()) : updatedUser.getUserRole();
			user.setUserRole(role);
		}
		entitymanager.merge(user);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return updatedUser;
	}
	@Override
	public void deleteUser(int userId)throws ApplicationException {
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		User deletedUser = entitymanager.find( User.class, userId);
		if (deletedUser == null ){
			entitymanager.close();
			throw new ApplicationException();
		}
		for (UserGoals goal : deletedUser.getUserGoals()){
			entitymanager.remove(goal);
		}
		for (Workout w : deletedUser.getWorkouts()){
			entitymanager.remove(w);
		}
		entitymanager.remove(deletedUser);
		entitymanager.getTransaction( ).commit( );
		entitymanager.close();
	}
	@Override
	public Roles getUserRoleByRoleName(String roleName) throws ApplicationException{
		EntityManager entitymanager = emfactory.createEntityManager( );
		Query query = entitymanager.createNamedQuery("Roles.getRoleByName");
		query.setParameter("name", roleName);
		
		Roles role = (Roles) query.getSingleResult();
		if (role == null){
			throw new ApplicationException();
		}
		
		return role;
	}
	@Override
	public List<User> getUserList() throws ApplicationException{
		EntityManager entitymanager = emfactory.createEntityManager( );
		Query query = entitymanager.createNamedQuery("User.getAllUsers");
		
		List<User> userList = (List<User>)query.getResultList();
		if (userList == null){
			throw new ApplicationException();
		}
		return userList;
	}}
