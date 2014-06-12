package org.mem.store.persistence.model;


import org.mem.store.query.model.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 30/11/13
 * Time: 7:02 PM
 *
 * Memory tables are loose equivalents of database tables.
 */
public interface MemTable<S extends SearchResult> {

    public <R extends Predicate> S lookup(R filter);
}
