package org.mem.store.persistence.model.invm;

import org.mem.store.persistence.model.MemoryTuple;
import org.mem.store.persistence.model.SearchResult;

import java.util.Collection;
import java.util.Iterator;

public interface InMemorySearchResult extends SearchResult {

	public Collection<MemoryTuple> getTuples();

    public int getCount();

	public Iterator<MemoryTuple> getTupleIterator();
}
