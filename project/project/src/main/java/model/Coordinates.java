package project;

@Entity
@Table(name = "workout_coordinates")
@AttributeOverride(name = "id", column = @Column(name = "coordinates_id", nullable = false))
public class Coordinates extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workout_id")
	private Workout workout;
	
	private float longitude;
	private float latitude;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	@JsonIgnore
	public Workout getWorkout() {
		return workout;
	}
	public void setWorkout(Workout workout) {
		this.workout = workout;
	}}

