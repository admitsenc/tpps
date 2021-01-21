public interface NodeRepository extends JpaRepository<Node, String> {
	  Node findByUrlAndUserId(final String url, final String userId);

	  List<Node> findAllByUserId(final String userId);

	  Node findByUserIdAndName(final String userId, final String name);
	}
