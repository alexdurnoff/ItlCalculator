package ru.durnov.expressions;

import java.util.Objects;
import java.util.Queue;

public class Symbol {
    private final Queue<String> queue;

    public Symbol(Queue<String> queue) {
        this.queue = queue;
    }

    public String symbol() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = queue.peek();
        if (Objects.requireNonNull(str).matches("[0-9]")) {
            stringBuilder.append(new NumberSymbol(queue).symbol());
        } else if (str.equals("(")) {
            stringBuilder.append(new BracketSymbol(queue).symbol());
        } else {
            stringBuilder.append(queue.remove());
        }
        return stringBuilder.toString();
    }
}
