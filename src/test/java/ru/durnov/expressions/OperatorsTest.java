package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {

    @Test
    void testExtractOperatorsFromString(){
        String source = "1+5-3*4+10";
        Operators operators = new Operators(source);
        assertEquals(5, operators.size());
    }


}