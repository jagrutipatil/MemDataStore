package org.mem.store.persistence.descriptor.impl;

import org.mem.store.persistence.descriptor.PartitionTableDescriptor;
import org.mem.store.persistence.descriptor.RangeDescriptor;
import org.mem.store.persistence.model.PartitionTableFactory;
import org.mem.store.persistence.model.invm.impl.PartitionedTableFactoryImpl;

/**
 * Partition descriptor is set once while creating
 */
public class PartitionTableDescriptorImpl implements PartitionTableDescriptor {

	private String partitionKey;

	private String tableName;

	private PartitionTableFactory partitionTableFactory;

	/**
	 * Expose partition key as interface
	 *
	 */
	public PartitionTableDescriptorImpl(String tableName, String partitionKey) {
		this.tableName = tableName;
		this.partitionKey = partitionKey;		
	}

	public String getPartitionKey() {
		return partitionKey;
	}

	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public void setTableFactory(PartitionTableFactory partitionTableFactory) {
		this.partitionTableFactory = partitionTableFactory;

	}

	@Override
	public PartitionTableFactory getTableFactory() {
		if (partitionTableFactory == null) {
			partitionTableFactory = new PartitionedTableFactoryImpl(this);
		}
		return partitionTableFactory;
	}
	
	@Override
	public RangeDescriptor<?> createRangeDescriptor(Object start, Object end) {
		return new GenericRangeDescriptorImpl(start, end);
	}
}
