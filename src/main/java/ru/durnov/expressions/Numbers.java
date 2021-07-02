package ru.durnov.expressions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private final static Pattern pattern = Pattern.compile("([0-9.]+)|([0-9.]+[*/][0-9.]+)");
    private final Queue<Number> numberQueue = new ArrayDeque<>();

    public Numbers(String str) {
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String match = matcher.group();
            if (match.matches("[0-9.]+[*/][0-9.]+")){
                numberQueue.add(new MultiplyOrDivideNumber(match));
            } else {
                System.out.println("before add SimpleNumber match is " + match);
                numberQueue.add(new SimpleNumber(Double.parseDouble(match)));
            }
        }
    }

    public Queue<Number> queue() {
        return this.numberQueue;
    }
}
