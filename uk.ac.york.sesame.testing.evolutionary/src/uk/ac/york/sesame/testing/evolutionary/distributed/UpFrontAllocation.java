package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.*;

public class UpFrontAllocation implements AllocationStrategy {
	
	@Override
	public Optional<WorkerNode> allocateTest(RemoteTest rt, Set<WorkerNode> availableNodes, Map<WorkerNode, List<RemoteTest>> currentAllocs) throws AllocationFailed {
		// Always allocate the tests; to the node with the lowest count.
		int minAllocCount = Integer.MAX_VALUE;
		Optional<WorkerNode> choice = Optional.empty();
		for (WorkerNode n : availableNodes) {
			
			int allocForNodeCount = currentAllocs.get(n).size();
			if (allocForNodeCount < minAllocCount) {
				minAllocCount = allocForNodeCount;
				choice = Optional.of(n);
			}
		}
		return choice;
	}
}