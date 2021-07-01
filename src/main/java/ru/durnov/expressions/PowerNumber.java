package ru.durnov.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PowerNumber implements Number{
    private final Double number;
    private final Double power;
    private final static Pattern pattern = Pattern.compile("([0-9.]+)([*/])([0-9.]+)");

    public PowerNumber(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()){
            this.number = Double.parseDouble(matcher.group(1));
            this.power = Double.parseDouble(matcher.group(2));
        } else {
            throw new IllegalArgumentException("Illegal expression");
        }
    }

    @Override
    public double value() {
        return Math.pow(number,power);
    }
}
