package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionStringTest {

    @Test
    void test1(){
        String source = "3-(3-8*5)";
        String result = new ExpressionString(source).string();
        assertEquals(result, "3+37.0");
    }

    @Test
    void test2(){
       String source = "7+(5-6*7)";
       String result = new ExpressionString(source).string();
        assertEquals(result, "7-37.0");
    }

    @Test
    void test3(){
        String source = "2,4000*7";
        String result = new ExpressionString(source).string();
        assertEquals(result, "16.8");
    }

    @Test
    void testWithNegativeResultExpected(){
        String source = "24^3+√144+(21*3-124567*2)";
        String result = new ExpressionString(source).string();
        assertEquals(result, "13824.0+12.0-249071.0");
    }

    @Test
    void test4(){
        String source = "93-5^23";
        String result = new ExpressionString(source).string();
        System.out.println(Double.parseDouble(result));
    }

}