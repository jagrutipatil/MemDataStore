package org.mem.store.query.exec;

import org.mem.store.query.model.ResultStream;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 29/11/13
 * Time: 10:38 AM
 *
 * Abstract representation of predicates in the query used by the
 * execution plan for query execution.
 */
public interface PredicateEvaluationTree {


    public <P extends PredicateEvaluator> void addEvaluator(P predicateEvaluator);


    /**
     * Visitor for issuing callbacks when each node type
     * in the evaluation tree is visited.
     */
    public <V extends PredicateEvaluationTreeVisitor, R extends ResultStream> R accept(V visitor);
}
