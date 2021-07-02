package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReplaceSQRTTest {

    @Test
    void tesThatReturnSameStringIfNoSQRTInExpression(){
        String source = "2,4000*7";
        String result = new StringReplaceSQRT(source).string();
        assertEquals(result, "2,4000*7");
    }

}