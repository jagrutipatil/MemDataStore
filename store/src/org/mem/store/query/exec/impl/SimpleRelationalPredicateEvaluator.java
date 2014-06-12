package org.mem.store.query.exec.impl;

import org.mem.store.persistence.model.invm.InMemorySearchResult;
import org.mem.store.persistence.service.invm.DataServiceFactory;
import org.mem.store.query.exec.AbstractSimplePredicateEvaluator;
import org.mem.store.query.exec.PredicateEvaluator;
import org.mem.store.query.exec.RelationalPredicateEvaluator;
import org.mem.store.query.exec.strategy.PredicateStrategy;
import org.mem.store.query.exec.strategy.impl.FilterIndexStrategyFactory;
import org.mem.store.query.model.Predicate;
import org.mem.store.query.model.RelationalPredicate;
import org.mem.store.query.model.ResultStream;
import org.mem.store.query.model.impl.MutableResultStream;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 10/12/13
 * Time: 10:47 AM
 * <p/>
 * Can have a binary/unary predicate.
 */
public class SimpleRelationalPredicateEvaluator extends AbstractSimplePredicateEvaluator<Predicate> implements RelationalPredicateEvaluator {

    private static final int NUM_OPERANDS = 1;

    private PredicateEvaluator nextEvaluator;

    public SimpleRelationalPredicateEvaluator(RelationalPredicate wrappedPredicate) {
        super(wrappedPredicate);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R extends ResultStream> R eval(R... inputResultStreams) {
        //We are interested in the first since there will be only 1.
        //There will be only one stream in pipeline strategy
        R mutableResultStream = (areEmptyInputStreams(inputResultStreams)) ?
                (R) evaluateFreshPredicate() : evaluatePipelinedPredicate(inputResultStreams[0]);
        if (nextEvaluator != null) {
            return nextEvaluator.eval(mutableResultStream);
        }
        return mutableResultStream;
    }

    private <R extends ResultStream> boolean areEmptyInputStreams(R... inputResultStreams) {
        return inputResultStreams == null || inputResultStreams.length == 0;
    }

    @SuppressWarnings("unchecked")
    private <R extends ResultStream> R evaluateFreshPredicate() {
        InMemorySearchResult memorySearchResult =
        		DataServiceFactory.getInstance().getDataStoreService().lookup(wrappedPredicate);
        return (R) createStreamFromSearchResults(memorySearchResult);
    }

    @SuppressWarnings("unchecked")
    private <R extends ResultStream> R evaluatePipelinedPredicate(R inputResultStream) {
        //TODO handle unary predicate
        PredicateStrategy predicateStrategy = FilterIndexStrategyFactory.INSTANCE.chooseStrategy(wrappedPredicate);
        return predicateStrategy.filter(inputResultStream);
    }

    private MutableResultStream createStreamFromSearchResults(InMemorySearchResult memorySearchResult) {
        MutableResultStream mutableResultStream = new MutableResultStream();        
        mutableResultStream.addMemoryTuples(memorySearchResult.getTuples());
        return mutableResultStream;
    }

    @Override
    public boolean isFull() {
        return nextEvaluator != null;
    }

    @Override
    public boolean addChildPredicateEvaluator(PredicateEvaluator childPredicateEvaluator) {
        if (nextEvaluator == null) {
            this.nextEvaluator = childPredicateEvaluator;
            return true;
        }
        return false;
    }

    @Override
    public int getNumOperands() {
        return NUM_OPERANDS;
    }
}
