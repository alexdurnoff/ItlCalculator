package ru.durnov.expressions;

import java.util.ArrayDeque;
import java.util.Queue;

public class Result {
    private final Queue<Number> numbers;
    private final Queue<Operator> operators;
    private Double result;

    public Result(Queue<Number> numbers, Queue<Operator> operators) {
        if (numbers.size() != operators.size()) throw new IllegalArgumentException(
                "Illegal expression"
        );
        this.numbers = numbers;
        this.operators = operators;
    }

    public Result(String first, String operator, String second){
        this.numbers = new ArrayDeque<>();
        this.operators = new ArrayDeque<>();
        this.numbers.add(new SimpleNumber(Double.parseDouble(first)));
        this.numbers.add(new SimpleNumber(Double.parseDouble(second)));
        this.operators.add(new StartOperator());
        this.operators.add(ArithmeticOperator.operatorByString(operator));
    }

    public Result(String str) {
        this(
                new Numbers(str).queue(),
                new Operators(str).queue()
        );
    }

    public double result(){
        if (this.result == null){
            this.result = 0.;
            while (! operators.isEmpty()){
                Operator operator = operators.remove();
                Number number = numbers.remove();
                this.result = operator.result(this.result, number.value());
            }
        }
        return this.result;
    }
}
