package ru.durnov.expressions;

import java.util.Queue;

public class NumberSymbol {
    private final Queue<String> queue;

    public NumberSymbol(Queue<String> queue) {
        this.queue = queue;
    }

    public String symbol() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = queue.remove();
        while (str.matches("[0-9]") || !queue.isEmpty()){
            stringBuilder.append(str);
            str = queue.remove();
        }
        return stringBuilder.toString();
    }
}
