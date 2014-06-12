package org.mem.store.persistence.model.invm.impl;

import org.mem.store.persistence.descriptor.TableDescriptor;
import org.mem.store.persistence.model.invm.MemoryPartition;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 10/1/14
 * Time: 2:06 PM
 *
 * Memory partition is equivalent of an in memory table.
 */
public class MemoryPartitionImpl extends InMemoryTableImpl implements MemoryPartition {

    public MemoryPartitionImpl(TableDescriptor tableDescriptor) {
        super(tableDescriptor);
    }
}
