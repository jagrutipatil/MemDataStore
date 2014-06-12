package org.mem.store.persistence.descriptor;

import org.mem.store.persistence.model.TableFactory;

public interface TableDescriptor<T extends TableFactory> {

	public String getTableName();

	public void setTableFactory(T tableFactory);
	
	public T getTableFactory();

}
