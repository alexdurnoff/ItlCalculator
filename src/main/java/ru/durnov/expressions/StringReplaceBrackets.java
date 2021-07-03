package ru.durnov.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplaceBrackets {
    private final StringBuffer stringBuffer = new StringBuffer();
    private final static Pattern pattern = Pattern.compile("\\((.+)\\)");

    public StringReplaceBrackets(String source) {
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()){
            matcher.appendReplacement(
                    stringBuffer,
                    String.format(
                            "%.10f",
                            new BracketNumber(matcher.group()).value()
                    )
            );
        }
        matcher.appendTail(stringBuffer);
    }

    public String string() {
        return stringBuffer.toString().replace(',', '.');
    }
}
