package org.mem.store.persistence.descriptor.impl;

import org.mem.store.persistence.descriptor.ColumnDescriptor;
import org.mem.store.persistence.descriptor.MemoryTableDescriptor;
import org.mem.store.persistence.descriptor.PartitionTableDescriptor;
import org.mem.store.query.model.DataType;

public class DescriptorFactory {

	public static ColumnDescriptor createColumnDescriptor(String name, DataType dataType, boolean isIndexed) {
		return new ColumnDescriptorImpl(name, dataType, isIndexed);
	}

	public static ColumnDescriptor createColumnDescriptor(String name) {
		return new ColumnDescriptorImpl(name);
	}

	public static ColumnDescriptor createColumnDescriptor(String name, DataType dataType) {
		return new ColumnDescriptorImpl(name, dataType);
	}

	
	public static PartitionTableDescriptor createPartitionTableDescriptor(String tableName, String partitionKey) {
		return new PartitionTableDescriptorImpl(tableName, partitionKey);
	}
	
	
	public static MemoryTableDescriptor createMemoryTableDescriptor(String tableName) {
		return new MemoryTableDescriptorImpl(tableName);
	} 
		
}
