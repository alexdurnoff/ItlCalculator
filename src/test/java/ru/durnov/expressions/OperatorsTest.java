package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {

    @Test
    void testHowLookSqrtSymbol(){
        String source = "123" + "\u221A" + "345";
        Queue<Operator> queue = new Operators(source).queue();
        assertEquals(2, queue.size());
        assertSame(queue.remove().getClass(), StartOperator.class);
        Operator operator = queue.remove();
        assertSame(operator.getClass(), ArithmeticOperator.class);
        assertSame(operator, ArithmeticOperator.SQRT);
        System.out.println(operator.symbol());
    }

    @Test
    void testExtractOperatorsFromString(){
        String source = "1+5-3*4+10";
        Queue<Operator> queue = new Operators(source).queue();
        assertEquals(5, queue.size());
        assertSame(queue.remove().getClass(), StartOperator.class);
        assertSame(queue.remove(), ArithmeticOperator.PLUS);
        assertSame(queue.remove(), ArithmeticOperator.MINUS);
        assertSame(queue.remove(), ArithmeticOperator.MULTIPLY);
        assertSame(queue.remove(), ArithmeticOperator.PLUS);
    }


}