package org.mem.store.query.exec.impl;

import org.mem.store.query.exec.PredicateEvaluator;
import org.mem.store.query.model.BinaryPredicate;
import org.mem.store.query.model.RelationalPredicate;
import org.mem.store.query.model.impl.SimpleQueryExpression;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 6/1/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class PredicateEvaluatorFactory {

    public static PredicateEvaluator createPredicateEvaluator(RelationalPredicate relationalPredicate) {
        if (isJoin(relationalPredicate)) {
            return new RelationalJoinPredicateEvaluator((BinaryPredicate<?>)relationalPredicate);
        } else {
            return new SimpleRelationalPredicateEvaluator(relationalPredicate);
        }
    }


    private static boolean isJoin(RelationalPredicate relationalPredicate) {
        return (relationalPredicate instanceof BinaryPredicate) &&
                ((BinaryPredicate) relationalPredicate).getRightExpression() instanceof SimpleQueryExpression;
    }

}
