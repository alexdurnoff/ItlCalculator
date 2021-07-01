package ru.durnov.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;

public class NumberButton extends Button implements CalculatorButton{
    private final Integer number;
    private final TextField textField;

    public NumberButton(Integer number, TextField textField) {
        this.number = number;
        this.textField = textField;
        this.setOnAction(ae -> addToTextField());
    }


    @Override
    public void addToTextField() {
        this.textField.setText(this.textField.getText() + this.number);
    }
}
