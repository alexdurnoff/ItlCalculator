package ru.durnov.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQRTNumber implements Number {
    private final Double number;
    private final static Pattern pattern = Pattern.compile("(\\u221a)([0-9.]+)");


    public SQRTNumber(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()){
            this.number = Double.parseDouble(matcher.group(2));
        } else {
            throw new IllegalArgumentException("Illegal expression");
        }
    }

    @Override
    public double value() {
        return Math.sqrt(this.number);
    }
}
