package org.mem.store.persistence.model.invm.impl;

import org.mem.store.persistence.descriptor.PartitionTableDescriptor;
import org.mem.store.persistence.model.MemTable;
import org.mem.store.persistence.model.PartitionTableFactory;

/**
 * Created by IntelliJ IDEA. User: aathalye Date: 13/1/14 Time: 11:57 AM
 * 
 * Default factory to create
 */
public class PartitionedTableFactoryImpl implements PartitionTableFactory {

	private PartitionTableDescriptor partitionDescriptor;

	public PartitionedTableFactoryImpl(PartitionTableDescriptor partitionDescriptor) {
		this.partitionDescriptor = partitionDescriptor;
	}

	@Override
	public MemTable<?> createTable() {
		return new PartitionedMemoryTable<Object>(partitionDescriptor);
	}

}
