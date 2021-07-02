package ru.durnov.dao;

import ru.durnov.expressions.Expression;

import javax.persistence.*;

@Entity
@Table(name = "expressions")
public class ExpressionEntity {

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "expression")
    private String expression;

    @Column(name = "result")
    private double result;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public ExpressionEntity(){

    }

    public ExpressionEntity(Expression exp){
        this.expression = exp.toString();
        this.result = exp.result();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
