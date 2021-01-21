import java.util.List;

@Entity
@Table(name = "workout")
@AttributeOverride(name = "id", column = @Column(name = "workout_id", nullable = false))
@NamedQueries({
	@NamedQuery(query = "SELECT w FROM Workout w WHERE w.user.id = :user_id ORDER BY w.id DESC", 
				name = "Workout.getWorkoutList")
})
public class Workout extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String duration;
	private double distanse;
	private long date;
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy = "workout")
	private List<Coordinates> coordinates = new ArrayList<Coordinates>();

	public Workout() {
		super();
	}
	public Workout(int id, User user, String duration, double distanse, long date) {
		super();
		this.id = id;
		this.user = user;
		this.duration = duration;
		this.distanse = distanse;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public double getDistanse() {
		return distanse;
	}
	public void setDistanse(double distanse) {
		this.distanse = distanse;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Coordinates> getCoordinates() {
		return coordinates;
	}
	public void addToCoordinates(Coordinates coord) {
        this.coordinates.add(coord);
        coord.setWorkout(this);
    }
    public void removeFromCoordinates(Coordinates coord) {
        this.coordinates.remove(coord);
        coord.setWorkout(null);
    }
}
