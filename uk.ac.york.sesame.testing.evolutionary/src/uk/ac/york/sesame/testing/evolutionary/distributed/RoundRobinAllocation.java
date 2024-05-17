package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class RoundRobinAllocation implements AllocationStrategy {
	public Optional<WorkerNode> allocateTest(RemoteTest rt, Set<WorkerNode> availableNodes, Map<RemoteTest, WorkerNode> currentAllocs) throws AllocationFailed {
		// Allocate to the first node with min count
		int minAllocCount = Integer.MAX_VALUE;
		Optional<WorkerNode> choice = Optional.empty();
		for (WorkerNode n : availableNodes) {
			if (n.activeTestCount() < minAllocCount) {
				minAllocCount = n.activeTestCount();
				choice = Optional.of(n);
			}
		}
		return choice;
	}
}