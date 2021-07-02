package ru.durnov.ui.controls;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.durnov.expressions.Operator;

public class OperatorButton extends Button implements CalculatorButton{
    private final Operator operator;
    private final TextField textField;

    public OperatorButton(Operator operator, TextField textField) {
        this.operator = operator;
        this.textField = textField;
        this.setWidth(160);
        this.setHeight(160);
        this.setText(operator.symbol());
        this.setOnAction(ae -> addToTextField());
    }


    @Override
    public void addToTextField() {
        this.textField.setText(this.textField.getText() + this.operator.symbol());
    }
}
