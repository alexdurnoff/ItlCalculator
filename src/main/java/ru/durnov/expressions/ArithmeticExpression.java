package ru.durnov.expressions;

public class ArithmeticExpression implements Expression {
    private final Double firstNumber;
    private final Double secondNumber;
    private final Operator operator;

    public ArithmeticExpression(Double firstNumber, Double secondNumber, Operator operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    public ArithmeticExpression(Double firstNumber, Double secondNumber, String operatorType){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = ArithmeticOperator.valueOf(operatorType);
    }


    @Override
    public Double result() {
        return this.operator.result(firstNumber, secondNumber);
    }

    @Override
    public String sql() {
        return "insert into expressions (first, second, operator. result) values("
                + this.firstNumber + ',' + this.secondNumber + ','
                + this.operator.symbol() + ',' + this.result() + ");";
    }

    @Override
    public String toString() {
        if (this.operator == ArithmeticOperator.SQRT){
            return this.operator.symbol() + this.firstNumber + "=" + result();
        } else {
            return this.firstNumber + this.operator.symbol() + this.secondNumber + "=" + result();
        }
    }
}
