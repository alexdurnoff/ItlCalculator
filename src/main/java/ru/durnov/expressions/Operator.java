package ru.durnov.expressions;

public interface Operator {
    double result(Double result, Double number);
    String symbol();
}
