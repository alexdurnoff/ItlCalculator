package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticExpressionTest {

    @Test
    void test1(){
        ArithmeticExpression expression = new ArithmeticExpression("6/2+3*4");
        Double result = expression.result();
        assertEquals(result, 15.0, 0.0001);
    }

}