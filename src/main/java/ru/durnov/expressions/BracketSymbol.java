package ru.durnov.expressions;

import java.util.Queue;

public class BracketSymbol {
    private final Queue<String> queue;

    public BracketSymbol(Queue<String> queue) {
        this.queue = queue;
    }


    public String symbol() {
        StringBuilder stringBuilder = new StringBuilder();
        int open = 1;
        int close = 0;
        while (close < open){
            String str = queue.remove();
            if (str.equals("(")) {
                open++;
            } else if (str.equals(")")) close++;
            stringBuilder.append(str);
        }
        String result = stringBuilder.toString();
        if (!result.contains("(")) {
            return String.valueOf(new BracketNumber(result.replace("(","").replace(")", "")));
        } else {
            return new Symbol(new StringQueue(result).queue()).symbol();
        }
    }
}
