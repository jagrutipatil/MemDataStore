package org.mem.store.persistence.service;


import org.mem.store.persistence.model.MemoryKey;
import org.mem.store.persistence.model.MemoryTuple;
import org.mem.store.persistence.model.SearchResult;
import org.mem.store.query.model.Predicate;

import java.util.Collection;

/**
 * Common service for accessing persistent stores.
 */
public interface DataStoreService {

	/**
	 * Put a new tuple in the specified table.
	 * 
	 * @param tableName
	 * @param node
	 */
	public void put(String tableName, MemoryTuple node);

	/**
	 * Remove a tuple from data store table.
	 * 
	 * @param tableName
	 * @param node
	 */
	public void remove(String tableName, MemoryTuple node);

	
	/**
	 * Remove a tuple from data store table.
	 * 
	 * @param tableName
	 * @param key
	 */
	public void remove(String tableName, MemoryKey key);

	/**
	 * Clear entire store for table
	 * 
	 * @param tableName
	 * 
	 */
	public void clear(String tableName);

	/**
	 * Remove a tuple from data store table.
	 * 
	 * @param tableName
	 * @param key
	 * @return {@link MemoryTuple}
	 */
	public MemoryTuple get(String tableName, MemoryKey key);
	
	/**
	 * 
	 * @param predicate
	 * @param <S>
	 * @return
	 */
	public <S extends SearchResult> S lookup(Predicate predicate);
	
    /**
     * Get size of the table: total number of memory tuples in the table
     *
     * @param tableName
     * @return size of table
     */
	public int getSizeOfTable(String tableName);


    /**
     * Get all tuples in the table
     *
     * @param tableName
     * @return Collection<MemoryTuple>
     */	
	public Collection<MemoryTuple> getAllTuples(String tableName);

    /**
     * Get tuple count for the predicate
     *
     * @param predicate
     * @return count
     */	
	public int getTupleCount(Predicate predicate);
	
}
