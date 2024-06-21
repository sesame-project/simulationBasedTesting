package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.*;

public class DynamicAllocation implements AllocationStrategy {
	
	@Override
	public Optional<WorkerNode> allocateTest(RemoteTest rt, Set<WorkerNode> availableNodes, Map<WorkerNode, List<RemoteTest>> currentAllocs) throws AllocationFailed {
		// Allocate to the first empty node
		for (WorkerNode n : availableNodes) {
			
			int allocForNodeCount = currentAllocs.get(n).size();
			if (allocForNodeCount == 0) {
				return Optional.of(n);
			}
		}
		
		// If no nodes are empty, do not allocate; wait until later to allocate test
		return Optional.empty();
	}
}