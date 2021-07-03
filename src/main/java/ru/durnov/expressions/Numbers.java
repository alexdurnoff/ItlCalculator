package ru.durnov.expressions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private final static Pattern pattern = Pattern.compile("([0-9.]+)|([0-9.]+[*/][0-9.]+)");
    private final Queue<Number> numberQueue = new ArrayDeque<>();

    public Numbers(String str) {
        Matcher matcher = pattern.matcher(str.replace(',', '.'));
        while (matcher.find()){
            String match = matcher.group();
            if (match.matches("[0-9.]+[*/][0-9.]+")){
                numberQueue.add(new MultiplyOrDivideNumber(match));
            } else {
                numberQueue.add(new SimpleNumber(Double.parseDouble(match)));
            }
        }
    }

    public boolean isEmtpy(){
        return this.numberQueue.isEmpty();
    }

    public Number nextNumber(){
        if (this.numberQueue.isEmpty()) throw new IllegalStateException("Numbers is empty");
        return this.numberQueue.remove();
    }

    public int size(){
        return this.numberQueue.size();
    }
}
