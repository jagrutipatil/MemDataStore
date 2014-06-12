package org.mem.store.persistence.service;

import org.mem.store.persistence.descriptor.PartitionTableDescriptor;
import org.mem.store.persistence.descriptor.RangeDescriptor;
import org.mem.store.persistence.model.invm.PartitionedTable;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 9/1/14
 * Time: 11:14 AM
 *
 * Use this manager to interact to the partition store.
 */
public interface PartitionManager<T> {

    public PartitionedTable getOrCreateTable(PartitionTableDescriptor partitionDescriptor);

    public PartitionedTable removePartition(RangeDescriptor<T> range);

    /**
     * Get matching partitioned table for a value.
     * If none is found new one is created.
     *
     */
    public PartitionedTable<PartitionTableDescriptor> getPartitionedTable(T value);
}
