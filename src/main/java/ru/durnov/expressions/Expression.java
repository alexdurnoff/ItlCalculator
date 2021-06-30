package ru.durnov.expressions;

public interface Expression {
    String toString();
    Double result();
    String sql();
}
