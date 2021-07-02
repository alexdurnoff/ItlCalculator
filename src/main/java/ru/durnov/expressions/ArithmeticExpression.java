package ru.durnov.expressions;

public class ArithmeticExpression implements Expression {
    private final String string;
    private final Result result;


    public ArithmeticExpression(String str){
        this.result = new Result(new ExpressionString(str).string());
        this.string = str;
    }

    public ArithmeticExpression(String first, String operator, String second){
        this.result = new Result(first + operator + second);
        this.string = first + operator + second;
    }

    @Override
    public Double result() {
        return this.result.result();
    }

    @Override
    public String sql() {
        return this.string;
    }

    @Override
    public String toString() {
        return this.string;
    }
}
