package ru.durnov.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.durnov.dao.DataBase;
import ru.durnov.expressions.*;

import java.sql.SQLException;

public class EqualButton extends Button implements CalculatorButton{
    private Double result;
    private final TextField textField;
    private final DataBase dataBase;

    public EqualButton(TextField textField, DataBase dataBase){
        this.textField = textField;
        this.dataBase = dataBase;
        this.setOnAction(ae -> addToTextField());
    }



    public void setResult(double result){
        this.result = result;
    }

    @Override
    public void addToTextField()  {
        String source = new ExpressionString(this.textField).string();
        Expression expression = new ArithmeticExpression(source);
        this.textField.setText(String.format("%.4f",expression.result()));
        try {
            dataBase.saveExpression(expression);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
