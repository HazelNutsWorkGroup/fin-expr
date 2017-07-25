package org.masking.finexpr.expr.operator;

import java.math.BigDecimal;
import java.math.MathContext;

import org.masking.finexpr.expr.ExprException;

public class UnaryPlusOperator extends Operator {

	public static final String SYMBOL = "+u";

	private static UnaryPlusOperator instance = new UnaryPlusOperator();

	private UnaryPlusOperator() {
		super(SYMBOL, 1, false, OperatorPrecedenceCode.UNARY_PLUS_MINUS);
	}

	@Override
	public BigDecimal apply(MathContext mc, BigDecimal... args) {
		if (mc == null)
			throw new ExprException("the MathContext cannot be null!");
		return args[0].add(BigDecimal.ZERO, mc);
	}

	public static UnaryPlusOperator getInstance() {
		return instance;
	}
}
