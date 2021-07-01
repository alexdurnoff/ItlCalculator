package ru.durnov.expressions;

public class BracketNumber implements Number{
    private final Expression expression;

    public BracketNumber(Expression expression) {
        this.expression = expression;
    }

    public BracketNumber(String str){
        if ((!str.startsWith("(")) && !(str.endsWith(")"))) throw new IllegalStateException("Illegal expression");
        this.expression = new ArithmeticExpression(
                str.replace("(", "").replace(")", "")
        );
    }

    @Override
    public double value() {
        return this.expression.result();
    }
}
