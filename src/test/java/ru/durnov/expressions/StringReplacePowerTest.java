package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReplacePowerTest {

    @Test
    void tesThatReturnSameStringIfNoPowerInExpression(){
        String source = "2,4000*7";
        String result = new StringReplacePower(source).string();
        assertEquals(result, "2,4000*7");
    }

    @Test
    void testWithBigNumber(){
        String source = "5^23";
        String result = new StringReplacePower(source).string();
        assertEquals(result, "11920928955078126,0000000000");
    }
}