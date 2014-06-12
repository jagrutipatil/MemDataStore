package org.mem.store.persistence.model.invm;

import org.mem.store.persistence.descriptor.ColumnDescriptor;
import org.mem.store.persistence.model.MemTable;
import org.mem.store.persistence.model.MemoryKey;
import org.mem.store.persistence.model.MemoryTuple;
import org.mem.store.query.model.Predicate;

import java.util.Collection;
import java.util.Iterator;

/**
 * In memory representation of a table.
 */
public interface InMemoryTable extends MemTable<InMemorySearchResult> {

    public void createIndex(ColumnDescriptor columnDescriptor);

	public String getTableName();

	public Iterator<String> getIndexNames();

	public void put(MemoryTuple node);

	public void remove(MemoryTuple node);
	
	public void remove(MemoryKey key);
	
	public MemoryTuple get(MemoryKey key);

	public boolean isIndexed(String indexName);

	public int getCardinality(String indexName);

    public int getTupleCount(Predicate predicate);

	public Collection<MemoryTuple> getAllTuples();

	public int getTuplesCount();
	
	public void clear();
}
