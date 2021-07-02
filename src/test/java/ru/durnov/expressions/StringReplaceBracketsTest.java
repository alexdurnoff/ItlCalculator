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

    @Test
    void test5(){
        String source = "2,4000*7";
        String result = new StringReplaceBrackets(source).string();
        assertEquals(result, "2,4000*7");
    }

    @Test
    void testWithNegativeResultExpected(){
        String source = "(21*3-124567*2)";
        String result = new StringReplaceBrackets(source).string();
        System.out.println(result);
    }

}