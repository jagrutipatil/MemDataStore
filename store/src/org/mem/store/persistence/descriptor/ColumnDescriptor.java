package org.mem.store.persistence.descriptor;

import org.mem.store.query.model.DataType;

public interface ColumnDescriptor {

	public String getName();

	public DataType getDataType();

	public boolean isIndexed();
}
