package org.mem.store.query.exec;

import org.mem.store.query.model.RelationalPredicate;
import org.mem.store.query.model.impl.AndPredicate;
import org.mem.store.query.model.impl.OrPredicate;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 17/12/13
 * Time: 4:16 PM
 *
 * Visitor for query model.
 */
public interface PredicateTreeVisitor {

    public void visit(AndPredicate andPredicate);

    public void visit(OrPredicate orPredicate);

    public void visit(RelationalPredicate relationalPredicate);

    public <P extends PredicateEvaluator> P getResult();
}
