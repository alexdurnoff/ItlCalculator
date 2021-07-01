package ru.durnov.expressions;

import java.util.Queue;

public class SimpleNumber implements Number{
    private final double value;

    public SimpleNumber(double value) {
        this.value = value;
    }

    @Override
    public double value() {
        return value;
    }
}
