import a.danylenko.microcontroller.automatization.project.data.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, String> {
  List<State> findAllByCommandId(final String commandId);
}
