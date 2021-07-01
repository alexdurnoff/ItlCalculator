package ru.durnov.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplaceMultiplyDivide {
    private final StringBuffer stringBuffer = new StringBuffer();
    private final static Pattern pattern = Pattern.compile("[0-9]+[*/][0-9]+");

    public StringReplaceMultiplyDivide(String source){
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()){
            matcher.appendReplacement(
                    stringBuffer,
                    String.valueOf(
                            new MultiplyOrDivideNumber(matcher.group()).value()
                    )
            );
        }
        matcher.appendTail(stringBuffer);
    }
    public String string() {
        String result = stringBuffer.toString();
        if (result.contains("*") || result.contains("|")) return new StringReplaceMultiplyDivide(
                stringBuffer.toString()
        ).string();
        return stringBuffer.toString();
    }
}


