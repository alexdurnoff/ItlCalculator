package ru.durnov.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplaceSQRT {
    private final StringBuffer stringBuffer = new StringBuffer();
    private final static Pattern pattern = Pattern.compile("\\u221a[0-9.]+");


    public StringReplaceSQRT(String source) {
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()){
            matcher.appendReplacement(
                    stringBuffer,
                    String.format(
                            "%.10f",
                            new SQRTNumber(matcher.group()).value()
                    )
            );
        }
        matcher.appendTail(stringBuffer);
    }

    public String string() {
        return this.stringBuffer.toString();
    }
}
