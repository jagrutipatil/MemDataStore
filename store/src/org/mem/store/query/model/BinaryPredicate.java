package org.mem.store.query.model;

import org.mem.store.persistence.model.MemoryTuple;
import org.mem.store.query.model.impl.SimpleQueryExpression;

public interface BinaryPredicate<T extends MemoryTuple> extends RelationalPredicate {
	
	public BinaryOperator getBinaryOperator();
	
	public SimpleQueryExpression getLeftExpression();

    public QueryExpression getRightExpression();

    public abstract boolean eval(T input);
}
