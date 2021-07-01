package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReplaceMultiplyDivideTest {

    @Test
    void test1(){
        String source = "2*3+6/1";
        String result = new StringReplaceMultiplyDivide(source).string();
        assertEquals(result, "6.0+6.0");
    }

}