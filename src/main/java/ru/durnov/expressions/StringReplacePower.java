package ru.durnov.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplacePower {
    private final StringBuffer stringBuffer = new StringBuffer();
    private final static Pattern pattern = Pattern.compile("[0-9]+\\^[0-9]+");

    public StringReplacePower(String source){
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()){
            matcher.appendReplacement(
                    stringBuffer,
                    String.valueOf(
                            new PowerNumber(matcher.group()).value()
                    )
            );
        }
        matcher.appendTail(stringBuffer);
    }

    public String string(){
        return this.stringBuffer.toString();
    }


}
