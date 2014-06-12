package org.mem.store.persistence.descriptor;

import org.mem.store.persistence.model.PartitionTableFactory;

public interface PartitionTableDescriptor extends TableDescriptor<PartitionTableFactory> {

	public String getPartitionKey();
	
	public RangeDescriptor<?> createRangeDescriptor(Object start, Object end);
	
}
