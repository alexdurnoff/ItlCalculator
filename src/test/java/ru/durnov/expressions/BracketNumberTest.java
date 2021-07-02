package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketNumberTest {

    @Test
    void test1(){
        String source = "(6/2+(3*4))";
        BracketNumber bracketNumber = new BracketNumber(source);
        assertEquals(bracketNumber.value(), 15.0, 0.001);
    }

}