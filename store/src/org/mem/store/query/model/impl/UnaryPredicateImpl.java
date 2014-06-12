package org.mem.store.query.model.impl;

import org.mem.store.query.exec.PredicateTreeVisitor;
import org.mem.store.query.model.UnaryExpression;
import org.mem.store.query.model.UnaryOperator;
import org.mem.store.query.model.UnaryPredicate;

public class UnaryPredicateImpl implements UnaryPredicate {

	protected UnaryExpression exp;

    protected UnaryOperator op;

	protected UnaryPredicateImpl(UnaryExpression exp, UnaryOperator op) {
		this.exp = exp;
		this.op = op;
	}

	@Override
	public <V extends PredicateTreeVisitor> void accept(V predicateTreeVisitor) {
		predicateTreeVisitor.visit(this);
	}

	@Override
	public UnaryOperator getOperator() {		
		return op;
	}

	@Override
	public UnaryExpression getExpression() {
		return exp;
	}

}
