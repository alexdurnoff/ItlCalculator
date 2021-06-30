package ru.durnov.expressions;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArithmeticExpression implements Expression {
    private final Queue<Double> doubleQueue;
    private final Queue<Operator> operatorQueue;

    public ArithmeticExpression(String str){
        this.doubleQueue = new Numbers(str).queue();
        this.operatorQueue = new Operators(str).queue();
    }


    public ArithmeticExpression(Double firstNumber, Double secondNumber, Operator operator) {
        this.doubleQueue = new ArrayDeque<>();
        this.doubleQueue.add(firstNumber);
        this.doubleQueue.add(secondNumber);
        this.operatorQueue = new ArrayDeque<>();
        this.operatorQueue.add(new StartOperator());
        this.operatorQueue.add(operator);

    }

    public ArithmeticExpression(Double firstNumber, Double secondNumber, String operatorType){
        Operator operator = ArithmeticOperator.valueOf(operatorType);
        this.doubleQueue = new ArrayDeque<>();
        this.doubleQueue.add(firstNumber);
        this.doubleQueue.add(secondNumber);
        this.operatorQueue = new ArrayDeque<>();
        this.operatorQueue.add(new StartOperator());
        this.operatorQueue.add(operator);
    }


    @Override
    public Double result() {
        return null;
    }

    @Override
    public String sql() {
        return null;
    }
}
