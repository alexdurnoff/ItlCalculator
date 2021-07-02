package ru.durnov.ui.controls;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.durnov.dao.DataBase;
import ru.durnov.exception.CalcAlert;
import ru.durnov.expressions.*;

import java.sql.SQLException;

public class EqualButton extends Button implements CalculatorButton{
    private final TextField textField;
    private final DataBase dataBase;

    public EqualButton(TextField textField, DataBase dataBase){
        this.textField = textField;
        this.dataBase = dataBase;
        this.setWidth(160);
        this.setHeight(160);
        this.setText("=");
        this.setOnAction(ae -> addToTextField());
    }

    @Override
    public void addToTextField()  {
        String str = new ExpressionString(this.textField).string();
        Expression expression = new ArithmeticExpression(this.textField.getText(), str);
        this.textField.setText(String.format("%.4f",expression.result()));
        try {
            this.dataBase.saveExpression(expression);
        } catch (SQLException exception) {
            new CalcAlert(exception, "Ошибка доступа к базе данных",
                    "Ощибка при попытке сохранить выражение");
        }
    }
}
