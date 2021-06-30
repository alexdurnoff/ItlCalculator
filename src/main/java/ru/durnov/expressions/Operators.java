package ru.durnov.expressions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operators {
    private final static Pattern pattern = Pattern.compile("[+[-]*/\\u221A]");
    private final Queue<Operator> operatorQueue = new ArrayDeque<>();


    public Operators(String str) {
        this.operatorQueue.add(new StartOperator());
        Matcher matcher = pattern.matcher(str);
        int count = matcher.groupCount();
        for (int i = 0; i < count; i++){
            this.operatorQueue.add(ArithmeticOperator.valueOf(matcher.group(i)));
        }
    }

    public Queue<Operator> queue() {
        return this.operatorQueue;
    }
}
