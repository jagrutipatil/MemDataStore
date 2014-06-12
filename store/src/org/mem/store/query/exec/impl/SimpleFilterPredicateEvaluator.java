package org.mem.store.query.exec.impl;

import org.mem.store.query.exec.FilterPredicateEvaluator;
import org.mem.store.query.exec.PredicateEvaluator;
import org.mem.store.query.model.LogicalPredicate;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 12/12/13
 * Time: 4:39 PM
 *
 * Works for logical predicate where filtering is required.
 */
public class SimpleFilterPredicateEvaluator<P extends PredicateEvaluator> extends SimpleBinaryPredicateEvaluator<P> implements FilterPredicateEvaluator<P> {

    private static final int NUM_OPERANDS = 1;

    public SimpleFilterPredicateEvaluator(LogicalPredicate wrappedPredicate) {
        super(wrappedPredicate);
    }

    public void clear() {
        predicateEvaluatorContainer.clear();
    }

    @Override
    public int getNumOperands() {
        return NUM_OPERANDS;
    }
}
