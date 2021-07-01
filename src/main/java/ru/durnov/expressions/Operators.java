package ru.durnov.expressions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operators {
    private final static Pattern pattern = Pattern.compile("[+[-]*/\\u221A]");
    private final Queue<Operator> operatorQueue = new ArrayDeque<>();


    public Operators(String str) {
        String source = str.replaceAll("\\([.]\\)", "");
        this.operatorQueue.add(new StartOperator());
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            this.operatorQueue.add(ArithmeticOperator.operatorByString(matcher.group()));
        }
    }

    public Queue<Operator> queue() {
        return this.operatorQueue;
    }
}
