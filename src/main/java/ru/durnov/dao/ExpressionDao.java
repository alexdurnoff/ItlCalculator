package ru.durnov.dao;

import ru.durnov.expressions.ArithmeticExpression;
import ru.durnov.expressions.Expression;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpressionDao implements DataBase{
    private final String url = "jdbc:sqlite:DB/history.sqlite3";
    private final Connection connection;
    private final PreparedStatement expressionListStatement;

    public ExpressionDao() throws SQLException {
        this.connection = DriverManager.getConnection(this.url);
        this.expressionListStatement = this.connection.prepareStatement("select * from expressions");
    }


    @Override
    public void saveExpression(Expression expression) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(expression.sql());
    }

    @Override
    public List<Expression> expressionList() throws SQLException {
        List<Expression> expressions = new ArrayList<>();
        ResultSet resultSet = expressionListStatement.getResultSet();
        for (int i = 0; i < 10; i ++){
            Expression expression = new ArithmeticExpression(
                    resultSet.getDouble(1),
                    resultSet.getDouble(2),
                    resultSet.getString(3)
            );
            expressions.add(expression);
        }
        return expressions;
    }
}
