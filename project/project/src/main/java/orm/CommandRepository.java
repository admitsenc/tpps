public interface CommandRepository extends JpaRepository<Command, String> {
	  List<Command> findAllByDeviceId(final String deviceId);
	}

