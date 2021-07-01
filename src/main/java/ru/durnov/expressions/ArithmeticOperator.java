package ru.durnov.expressions;

public enum ArithmeticOperator implements Operator{
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    POWER("^"),
    SQRT("\u221A")
    ;

    private final String symbol;


    ArithmeticOperator(String symbol){
        this.symbol = symbol;
    }

    @Override
    public double result(Double result, Double number) {
        if (this == PLUS) return result + number;
        if (this == MINUS) return result - number;
        if (this == DIVIDE) return result / number;
        if (this == MULTIPLY) return result * number;
        if (this == POWER) return Math.pow(result, number);
        return Math.sqrt(result);
    }

    @Override
    public String symbol() {
        return this.symbol;
    }

    public static Operator operatorByString(String str){
        if (str.equals("+")) return PLUS;
        if (str.equals("-")) return MINUS;
        if (str.equals("*")) return MULTIPLY;
        if (str.equals("/")) return DIVIDE;
        if (str.equals("\u221A")) return SQRT;
        throw new IllegalArgumentException("Illegal operator");
    }
}
