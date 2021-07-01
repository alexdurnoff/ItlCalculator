package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReplaceBracketsTest {

    @Test
    void testSimpleBrecketExpression(){
        String source = "1+(2+3)";
        String result = new StringReplaceBrackets(source).string();
        assertEquals(result, "1+5.0");
    }

    @Test
    void testComplexBracketExpression(){
        String source = "1+(2+3 + (6-1))";
        String result = new StringReplaceBrackets(source).string();
        assertEquals(result, "1+10.0");
    }

    @Test
    void testComplexBracketAndNumberAtEnd(){
        String source = "1+(2+3+(6-1))+4-1";
        String result = new StringReplaceBrackets(source).string();
        assertEquals("1+10.0+4-1", result);
    }

    @Test
    void testExpressionWithMultiply(){
        String source = "1+(2*3+(6/1))+4-1";
        String result = new StringReplaceBrackets(source).string();
        assertEquals(result, "1+12.0+4-1");
    }

}