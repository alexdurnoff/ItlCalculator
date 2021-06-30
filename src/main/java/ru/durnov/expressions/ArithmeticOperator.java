package ru.durnov.expressions;

public enum ArithmeticOperator implements Operator{
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    POWER("^"),
    SQRT("\\u221A")
    ;

    private final String symbol;


    ArithmeticOperator(String symbol){
        this.symbol = symbol;
    }

    @Override
    public double result(Double first, Double second) {
        if (this == PLUS) return first + second;
        if (this == MINUS) return first - second;
        if (this == DIVIDE) return first/second;
        if (this == MULTIPLY) return first*second;
        if (this == POWER) return Math.pow(first, second);
        return Math.sqrt(first);
    }

    @Override
    public String symbol() {
        return this.symbol;
    }
}
