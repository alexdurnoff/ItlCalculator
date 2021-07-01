package ru.durnov.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.durnov.expressions.Operator;

public class OperatorButton extends Button implements CalculatorButton{
    private final Operator operator;
    private final TextField textField;

    public OperatorButton(Operator operator, TextField textField) {
        this.operator = operator;
        this.textField = textField;
        this.setOnAction(ae -> addToTextField());
    }


    @Override
    public void addToTextField() {
        this.textField.setText(this.textField.getText() + this.operator.symbol());
    }
}
