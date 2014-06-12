package org.mem.store.query.model;

import org.mem.store.persistence.model.MemoryTuple;

import java.util.Iterator;


/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 18/12/13
 * Time: 12:13 PM
 * <p/>
 * This is the result set form to be returned to caller upon query execution.
 */
public interface QueryResultSet extends Iterator<MemoryTuple> {

    /**
     * Return total tuple count.
     */
    public int totalCount();

}
