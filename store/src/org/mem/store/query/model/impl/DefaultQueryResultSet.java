package org.mem.store.query.model.impl;

import org.mem.store.persistence.model.MemoryTuple;
import org.mem.store.query.model.QueryResultSet;
import org.mem.store.query.model.ResultStream;

import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 28/11/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultQueryResultSet implements QueryResultSet {
   
    private Iterator<MemoryTuple> resultIterator;
    
    private int totalCount;

    public DefaultQueryResultSet(ResultStream resultStream) {
        totalCount = resultStream.getTuples().size();
        resultIterator = resultStream.getTuples().iterator();
    }

    @Override
    public int totalCount() {
        return totalCount;
    }
    
	@Override
	public boolean hasNext() {		
		return resultIterator.hasNext();
	}

	@Override
	public MemoryTuple next() {		
		return resultIterator.next();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub		
	}

}
