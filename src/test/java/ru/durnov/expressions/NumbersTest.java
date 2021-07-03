package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void test1(){
        String source = "1+2+3*4+5";
        Numbers numbers = new Numbers(source);
        Number number = numbers.nextNumber();
        assertSame(number.getClass(), SimpleNumber.class);
        assertEquals(number.value(),1., 0.0001);
        number = numbers.nextNumber();
        assertSame(number.getClass(), SimpleNumber.class);
        assertEquals(number.value(),2., 0.0001);
        number = numbers.nextNumber();
        assertSame(number.getClass(), SimpleNumber.class);
        assertEquals(number.value(),3., 0.0001);
        number = numbers.nextNumber();
        assertSame(number.getClass(), SimpleNumber.class);
        assertEquals(number.value(),4., 0.0001);
        number = numbers.nextNumber();
        assertSame(number.getClass(), SimpleNumber.class);
        assertEquals(number.value(),5., 0.0001);
    }

}