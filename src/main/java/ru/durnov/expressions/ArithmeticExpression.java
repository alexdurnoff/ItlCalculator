package ru.durnov.expressions;

public class ArithmeticExpression implements Expression {
    private final String request;
    private final Result result;

    public ArithmeticExpression(String str){
        this.result = new Result(str);
        this.request = str + "=" + String.format("%.2f", this.result.result());
    }

    public ArithmeticExpression(String first, String operator, String second){
        this.result = new Result(first + operator + second);
        this.request = first + operator + second + "=" + String.format("%.2f", this.result.result());
    }

    @Override
    public Double result() {
        return this.result.result();
    }

    @Override
    public String sql() {
        return this.request;
    }
}
