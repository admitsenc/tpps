@Entity
@Table(name = "goals")
@AttributeOverride(name = "id", column = @Column(name = "goals_id", nullable = false))
public class Goals extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private double distance;
	private String description;	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "goal")
	@CascadeOnDelete
	private List<UserGoals> userGoals;
	public Goals() {
	}
	public Goals(int id, int distance, String description) {
		super();
		this.id = id;
		this.distance = distance;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	@JsonIgnore
	public List<UserGoals> getUserGoals() {
		return userGoals;
	}
	public void setUserGoals(List<UserGoals> userGoals) {
		this.userGoals = userGoals;
	}}

