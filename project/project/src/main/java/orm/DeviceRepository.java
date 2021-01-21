public interface DeviceRepository extends JpaRepository<Device, String> {
	  List<Device> findAllByNodeId(final String nodeId);

	  List<Device> findAllByUserId(final String userId);
	}
