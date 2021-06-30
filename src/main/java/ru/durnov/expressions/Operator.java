package ru.durnov.expressions;

public interface Operator {
    double result(Double firstNumber, Double secondNumber);
    String symbol();
}
