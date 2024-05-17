package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface AllocationStrategy {
	public Optional<WorkerNode> allocateTest(RemoteTest rt, Set<WorkerNode> availableNodes, Map<RemoteTest, WorkerNode> currentAllocs) throws AllocationFailed;
}
