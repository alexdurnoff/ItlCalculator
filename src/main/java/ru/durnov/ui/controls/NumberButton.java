package ru.durnov.ui.controls;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NumberButton extends Button implements CalculatorButton{
    private final Integer number;
    private final TextField textField;

    public NumberButton(Integer number, TextField textField) {
        this.number = number;
        this.textField = textField;
        this.setWidth(160);
        this.setHeight(160);
        this.setText(String.valueOf(this.number));
        this.setOnAction(ae -> addToTextField());
    }


    @Override
    public void addToTextField() {
        this.textField.setText(this.textField.getText() + this.number);
    }
}
