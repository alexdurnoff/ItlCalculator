package ru.durnov.expressions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private final static Pattern pattern = Pattern.compile("[0-9.]");
    private final Queue<Double> doubleQueue = new ArrayDeque<>();

    public Numbers(String str) {
        Matcher matcher = pattern.matcher(str);
        int count = matcher.groupCount();
        for (int i = 0; i < count; i++){
            this.doubleQueue.add(Double.valueOf(matcher.group(i)));
        }
    }

    public Queue<Double> queue() {
        return this.doubleQueue;
    }
}
