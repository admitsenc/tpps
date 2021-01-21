import java.util.List;

public interface CoordinatesDao {
	public List<Coordinates> getCoordinatesList(int WorkoutId);
	public void saveCoordinate(float latitude, float longitude, Workout workout);
	public void saveCoordinateList(List<Coordinates> coord) throws ApplicationException;
	public void deleteCoordinates(int coordinateId);

}
