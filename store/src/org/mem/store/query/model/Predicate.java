package org.mem.store.query.model;


import org.mem.store.query.exec.PredicateTreeVisitor;

public interface Predicate {

    public <V extends PredicateTreeVisitor> void accept(V predicateTreeVisitor);
}
