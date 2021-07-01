package ru.durnov.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void test1(){
        String source = "6/2+3*4";
        System.out.println(Double.parseDouble(source));
    }

}