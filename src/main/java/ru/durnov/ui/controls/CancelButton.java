package ru.durnov.ui.controls;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CancelButton extends Button implements CalculatorButton{
    private final TextField textField;

    public CancelButton(TextField textField) {
        this.textField = textField;
        this.setWidth(160);
        this.setHeight(160);
        this.setText("C");
        this.setOnAction(ae -> addToTextField());
    }


    @Override
    public void addToTextField() {
        this.textField.setText("");
    }
}
