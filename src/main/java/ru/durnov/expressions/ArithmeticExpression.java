package ru.durnov.expressions;

public class ArithmeticExpression implements Expression {
    private final String sourceString;
    private final String string;
    private final Result result;


    public ArithmeticExpression(String str){
        this.result = new Result(new ExpressionString(str).string());
        this.string = str;
        this.sourceString = str;
    }

    public ArithmeticExpression(String sourceString, String str){
        this.sourceString = sourceString;
        this.string = str;
        this.result = new Result(new ExpressionString(str).string());
    }


    public ArithmeticExpression(String first, String operator, String second){
        this.result = new Result(first + operator + second);
        this.string = first + operator + second;
        this.sourceString = string;
    }

    @Override
    public Double result() {
        return this.result.result();
    }

    @Override
    public String toString() {
        return this.sourceString;
    }
}
