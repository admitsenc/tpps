package project;

@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "user_id", nullable = false))
@NamedQueries({
	@NamedQuery(query = "Select u from User u where u.email = :email and u.password = :password", 
			name = "User.login"),
	@NamedQuery(query = "SELECT u FROM User u WHERE u.email = :email", 
	name = "User.getUserByLogin"),
	@NamedQuery(query = "SELECT u FROM User u", 
	name = "User.getAllUsers")
})
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Roles userRole;

	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserGoals> userGoals;
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Workout> workouts;

	public User(){
		super();
	}
	public User(int id, String email, String password, String firstName, String lastName, Roles role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Roles getUserRole() {
		return userRole;
	}
	public void setUserRole(Roles role) {
		this.userRole = role;
}
	@JsonIgnore
	public List<UserGoals> getUserGoals() {
		return userGoals;
	}
	public void setUserGoals(List<UserGoals> userGoals) {
		this.userGoals = userGoals;
	}
	@JsonIgnore
	public List<Workout> getWorkouts() {
		return workouts;
	}
	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}}
