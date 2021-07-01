package ru.durnov.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiplyOrDivideNumber implements Number{
    private final Expression expression;
    private final static Pattern pattern = Pattern.compile("([0-9]+)([*/])([0-9]+)");

    public MultiplyOrDivideNumber(String str){
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()){
            this.expression = new ArithmeticExpression(matcher.group(1), matcher.group(2), matcher.group(3));
        } else if (matcher.find()){
            this.expression = new ArithmeticExpression(str);
        } else {
            throw new IllegalArgumentException("Illegal expression");
        }
    }

    @Override
    public double value() {
        return this.expression.result();
    }
}
