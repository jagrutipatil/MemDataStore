package org.mem.store.query.exec.impl;

import org.mem.store.persistence.service.invm.DataServiceFactory;
import org.mem.store.query.exec.AbstractCostBasedPredicateEvaluator;
import org.mem.store.query.exec.CostBasedPredicateEvaluator;
import org.mem.store.query.exec.RelationalPredicateEvaluator;
import org.mem.store.query.model.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 15/12/13
 * Time: 12:50 PM
 * TODO Needs some proper refactoring.
 */
public class CostBasedRelationalPredicateEvaluator extends AbstractCostBasedPredicateEvaluator<RelationalPredicateEvaluator> implements CostBasedPredicateEvaluator, RelationalPredicateEvaluator {

    public CostBasedRelationalPredicateEvaluator(RelationalPredicateEvaluator wrappedPredicateEvaluator) {
        super(wrappedPredicateEvaluator);
        computeCost();
    }

    @Override
    public void computeCost() {
        Predicate wrappedPredicate = wrappedPredicateEvaluator.getWrappedPredicate();

        //TODO handle table name properly
        //TODO handle unary expression.
        //TODO Handle various cost evaluation criteria
        cost = DataServiceFactory.getInstance().getDataStoreService().getTupleCount(wrappedPredicate);
    }
}
