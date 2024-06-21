package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface AllocationStrategy {
	public Optional<WorkerNode> allocateTest(RemoteTest rt, Set<WorkerNode> availableNodes, Map<WorkerNode, List<RemoteTest>> currentAllocs) throws AllocationFailed;
}
