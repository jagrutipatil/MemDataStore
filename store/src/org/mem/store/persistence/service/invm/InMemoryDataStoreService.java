package org.mem.store.persistence.service.invm;


import org.mem.store.persistence.model.MemoryKey;
import org.mem.store.persistence.model.MemoryTuple;
import org.mem.store.persistence.model.SearchResult;
import org.mem.store.persistence.model.invm.impl.InMemoryDataStore;
import org.mem.store.persistence.service.DataStoreService;
import org.mem.store.query.model.BinaryPredicate;
import org.mem.store.query.model.Predicate;
import org.mem.store.query.model.impl.SimpleQueryExpression;

import java.util.Collection;

public class InMemoryDataStoreService implements DataStoreService {
	
	private InMemoryDataStore inMemoryDataStore = InMemoryDataStore.INSTANCE;

	@Override
	public void put(String tableName, MemoryTuple node) {
		inMemoryDataStore.put(tableName, node);
	}

	@Override
	public void remove(String tableName, MemoryTuple node) {
		inMemoryDataStore.remove(tableName, node);
	}

	@Override
    @SuppressWarnings("unchecked")
	public <S extends SearchResult> S lookup(Predicate predicate) {
        String tableName = null;
        if (predicate instanceof BinaryPredicate) {
            final SimpleQueryExpression queryExpression = ((BinaryPredicate) predicate).getLeftExpression();
            tableName = queryExpression.getTableName();
        }
		return (S) inMemoryDataStore.lookup(tableName, predicate);
	}

	@Override
	public MemoryTuple get(String tableName, MemoryKey key) {
		return inMemoryDataStore.get(tableName, key);
	}

	@Override
	public void remove(String tableName, MemoryKey key) {
		inMemoryDataStore.remove(tableName, key);
	}

	@Override
	public int getSizeOfTable(String tableName) {		
		return inMemoryDataStore.getSizeOfTable(tableName);
	}

	@Override
	public Collection<MemoryTuple> getAllTuples(String tableName) {
		return inMemoryDataStore.getAllTuples(tableName);
	}

	@Override
	public void clear(String tableName) {
		inMemoryDataStore.clear(tableName);
	}

	@Override
	public int getTupleCount(Predicate predicate) {
        return inMemoryDataStore.getTupleCount(predicate);
	}

}
