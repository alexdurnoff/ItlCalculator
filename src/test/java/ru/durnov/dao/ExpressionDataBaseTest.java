package ru.durnov.dao;

import org.junit.jupiter.api.Test;
import ru.durnov.expressions.ArithmeticExpression;
import ru.durnov.expressions.Expression;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionDataBaseTest {
    private final DataBase dataBase = new ExpressionDataBase();

    @Test
    void testOneExpression() throws SQLException {
        Expression expression = new ArithmeticExpression("1+2");
        this.dataBase.saveExpression(expression);
    }

    @Test
    void testSave11Expression() throws SQLException {
        Expression expression1 = new ArithmeticExpression("3+1");
        this.dataBase.saveExpression(expression1);
        Expression expression2 = new ArithmeticExpression("4+5");
        this.dataBase.saveExpression(expression2);
        Expression expression3 = new ArithmeticExpression("8*4");
        this.dataBase.saveExpression(expression3);
        Expression expression4 = new ArithmeticExpression("5+3-2");
        this.dataBase.saveExpression(expression4);
        Expression expression5 = new ArithmeticExpression("4+2-1");
        this.dataBase.saveExpression(expression5);
        Expression expression6 = new ArithmeticExpression("4+4+6");
        this.dataBase.saveExpression(expression6);
        Expression expression7 = new ArithmeticExpression("10*3");
        this.dataBase.saveExpression(expression7);
        Expression expression8 = new ArithmeticExpression("10-17");
        this.dataBase.saveExpression(expression8);
        Expression expression9 = new ArithmeticExpression("1-5");
        this.dataBase.saveExpression(expression9);
        Expression expression10 = new ArithmeticExpression("15-3");
        this.dataBase.saveExpression(expression10);
        Expression expression11 = new ArithmeticExpression("16-4");
        this.dataBase.saveExpression(expression11);
        List<ExpressionEntity> expressions = this.dataBase.expressionList();
        assertEquals(10, expressions.size());
    }

}