package ru.durnov.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CancelButton extends Button implements CalculatorButton{
    private final TextField textField;

    public CancelButton(TextField textField) {
        this.textField = textField;
        this.setOnAction(ae -> addToTextField());
    }


    @Override
    public void addToTextField() {
        this.textField.setText("");
    }
}
