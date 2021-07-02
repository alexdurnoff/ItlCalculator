package ru.durnov.dao;

public class ExpressionEntityComparator implements java.util.Comparator<ExpressionEntity> {
    @Override
    public int compare(ExpressionEntity o1, ExpressionEntity o2) {
        return Long.compare(o2.getId(), o1.getId());
    }
}
