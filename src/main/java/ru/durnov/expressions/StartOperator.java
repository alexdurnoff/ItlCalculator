package ru.durnov.expressions;

public class StartOperator implements Operator {


    @Override
    public double result(Double result, Double number) {
        return number;
    }

    @Override
    public String symbol() {
        return "";
    }
}
