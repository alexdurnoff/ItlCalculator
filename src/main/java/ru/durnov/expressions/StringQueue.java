package ru.durnov.expressions;


import java.util.ArrayDeque;
import java.util.Queue;

public class StringQueue {
    private final Queue<String> queue = new ArrayDeque<>();
    public StringQueue(String str) {
        for (int i = 0; i < str.length(); i++){
            queue.add(String.valueOf(str.charAt(i)));
        }
    }

    public Queue<String> queue() {
        return this.queue;
    }
}
