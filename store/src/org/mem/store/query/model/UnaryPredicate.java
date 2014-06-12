package org.mem.store.query.model;

public interface UnaryPredicate extends RelationalPredicate {
	
	public UnaryOperator getOperator();
	
	public UnaryExpression getExpression();
}
