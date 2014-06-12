package org.mem.store.query.exec.impl;

import org.mem.store.query.exec.PredicateEvaluator;
import org.mem.store.query.model.impl.ValueExpression;
import org.mem.store.persistence.model.invm.InMemorySearchResult;
import org.mem.store.persistence.service.invm.DataServiceFactory;
import org.mem.store.query.exec.AbstractSimplePredicateEvaluator;
import org.mem.store.query.exec.JoinPredicateEvaluator;
import org.mem.store.query.exec.strategy.impl.NestedLoopJoinStrategy;
import org.mem.store.query.model.BinaryOperator;
import org.mem.store.query.model.BinaryPredicate;
import org.mem.store.query.model.ResultStream;
import org.mem.store.query.model.impl.EqualsPredicate;
import org.mem.store.query.model.impl.JoinKey;
import org.mem.store.query.model.impl.MutableResultStream;
import org.mem.store.query.model.impl.SimpleQueryExpression;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 6/1/14
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class RelationalJoinPredicateEvaluator extends AbstractSimplePredicateEvaluator<BinaryPredicate<?>> implements JoinPredicateEvaluator {

    public RelationalJoinPredicateEvaluator(BinaryPredicate<?> wrappedPredicate) {
        super(wrappedPredicate);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R extends ResultStream> R eval(R... inputResultStreams) {
        //Create 2
        SimpleQueryExpression leftExpression = wrappedPredicate.getLeftExpression();
        SimpleQueryExpression rightExpression = (SimpleQueryExpression) wrappedPredicate.getRightExpression();

        EqualsPredicate lhsEqualsPredicate = new EqualsPredicate(leftExpression, new ValueExpression<String>("*"), BinaryOperator.EQ);
        EqualsPredicate rhsEqualsPredicate = new EqualsPredicate(rightExpression, new ValueExpression<String>("*"), BinaryOperator.EQ);
        //Evaluate
        InMemorySearchResult memorySearchResult =
         		DataServiceFactory.getInstance().getDataStoreService().lookup(lhsEqualsPredicate);
        MutableResultStream leftResultStream = createStreamFromSearchResults(memorySearchResult);

        JoinKey joinKey = new JoinKey(leftExpression.getTableName(), leftExpression.getOperand());
        NestedLoopJoinStrategy joinStrategy = new NestedLoopJoinStrategy(rhsEqualsPredicate, joinKey);
        return (R) joinStrategy.filter(leftResultStream);
    }

    /**
     * TODO move this into utility class.
     *
     */
    private MutableResultStream createStreamFromSearchResults(InMemorySearchResult memorySearchResult) {
        MutableResultStream mutableResultStream = new MutableResultStream();       
        mutableResultStream.addMemoryTuples(memorySearchResult.getTuples());
        return mutableResultStream;
    }

    @Override
    public boolean addChildPredicateEvaluator(PredicateEvaluator childPredicateEvaluator) {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getNumOperands() {
        return 0;
    }
}
