package ru.durnov.ui.controls;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CloseBracketButton extends Button implements CalculatorButton{
    private final TextField textField;

    public CloseBracketButton(TextField textField) {
        this.textField = textField;
        this.setText(")");
        this.setOnAction(ae -> addToTextField());
    }


    @Override
    public void addToTextField() {
        this.textField.setText(this.textField.getText() + ")");
    }
}
