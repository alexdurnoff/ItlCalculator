package ru.durnov.dao;

import ru.durnov.expressions.Expression;

import java.sql.SQLException;
import java.util.List;

public interface DataBase {
    void saveExpression(Expression expression) throws SQLException;
    List<ExpressionEntity> expressionList();
}
