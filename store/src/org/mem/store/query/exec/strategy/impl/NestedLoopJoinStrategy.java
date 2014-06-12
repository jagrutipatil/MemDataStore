package org.mem.store.query.exec.strategy.impl;

import org.mem.store.query.model.impl.ValueExpression;
import org.mem.store.persistence.model.MemoryTuple;
import org.mem.store.persistence.model.invm.InMemorySearchResult;
import org.mem.store.persistence.service.invm.DataServiceFactory;
import org.mem.store.query.exec.strategy.JoinStrategy;
import org.mem.store.query.model.BinaryOperator;
import org.mem.store.query.model.BinaryPredicate;
import org.mem.store.query.model.ResultStream;
import org.mem.store.query.model.impl.EqualsPredicate;
import org.mem.store.query.model.impl.JoinKey;
import org.mem.store.query.model.impl.MutableResultStream;

/**
 * Created by IntelliJ IDEA.
 * User: aathalye
 * Date: 6/1/14
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class NestedLoopJoinStrategy implements JoinStrategy {

    private BinaryPredicate<?> binaryPredicate;

    private JoinKey joinKey;

    public NestedLoopJoinStrategy(BinaryPredicate<?> binaryPredicate, JoinKey joinKey) {
        this.binaryPredicate = binaryPredicate;
        this.joinKey = joinKey;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R extends ResultStream> R filter(R inputResultStream) {
        MutableResultStream outputResultStream = new MutableResultStream();

        for (MemoryTuple tuple : inputResultStream.getTuples()) {
            Object attributeValue = tuple.getAttributeValue(joinKey.getColumnName());
            //Construct predicate on the fly
            EqualsPredicate equalsPredicate =
                    new EqualsPredicate(binaryPredicate.getLeftExpression(), new ValueExpression<Object>(attributeValue), BinaryOperator.EQ);
            InMemorySearchResult searchResult = DataServiceFactory.getInstance().getDataStoreService().lookup(equalsPredicate);
            //If match found we should get 1 result else 0        
            outputResultStream.addMemoryTuples(searchResult.getTuples());           
        }
        return (R) outputResultStream;
    }
}
