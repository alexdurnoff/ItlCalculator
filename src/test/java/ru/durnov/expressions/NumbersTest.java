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
        Queue<Number> queue = numbers.queue();
        Number number = queue.remove();
        assertSame(number.getClass(), SimpleNumber.class);
        assertEquals(number.value(),1., 0.0001);
        number = queue.remove();
        assertSame(number.getClass(), SimpleNumber.class);
        assertEquals(number.value(),2., 0.0001);
        Number multiNumber = queue.remove();
        assertSame(multiNumber.getClass(), MultiplyOrDivideNumber.class);
        assertEquals(multiNumber.value(),12., 0.0001);
        number = queue.remove();
        assertSame(number.getClass(), SimpleNumber.class);
        assertEquals(number.value(),5., 0.0001);
    }

    @Test
    void testWithInnerBrackets(){
        String source = "1+(6/2+(3*4))";
        Queue<Number> queue = new Numbers(source).queue();
        queue.forEach(number -> {
            System.out.println(number.value());
        });
    }

    @Test
    void test3(){
        String source = "6/2+(3*4)";
        Queue<Number> queue = new Numbers(source).queue();
        queue.forEach(number -> {
            System.out.println(number.value());
        });
    }

    @Test
    void testRegularExpression(){
        Pattern pattern = Pattern.compile("([0-9]+)|(\\((.+)\\))|([0-9]+[*/][0-9]+)");
        Matcher matcher = pattern.matcher("1+(6/2+(3*4)) + (4+2)");
        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }

    @Test
    void testMultiplyOrDivideExpression(){
        Pattern pattern = Pattern.compile("([0-9]+)|(\\((.+)\\))|([0-9]+[*/][0-9]+)");
        Matcher matcher = pattern.matcher("1+(6/2+(3*4)) + (4+2)");
        int start = 0;
        while (matcher.find(start)){
            System.out.println(matcher.group());
            start = matcher.end() + 1;
        }
    }

}