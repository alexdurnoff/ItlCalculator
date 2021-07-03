package ru.durnov.expressions;

public class Result {
    private final Numbers numbers;
    private final Operators operators;
    private Double result;

    public Result(Numbers numbers, Operators operators) {
        if (numbers.size() != operators.size()) throw new IllegalArgumentException(
                "Illegal expression"
        );
        this.numbers = numbers;
        this.operators = operators;
    }

    public Result(String str) {
        this(
                new Numbers(str),
                new Operators(str)
        );
    }

    public double result(){
        if (this.result == null){
            this.result = 0.;
            while (! operators.isEmpty()){
                this.result = this.operators.result(this.result, this.numbers);
            }
        }
        return this.result;
    }
}
