package ru.durnov.ui.controls;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class OpenBracketButton extends Button implements CalculatorButton {
    private final TextField textField;

    public OpenBracketButton(TextField textField) {
        this.textField = textField;
        this.setText("(");
        this.setOnAction(ae -> addToTextField());
    }


    @Override
    public void addToTextField() {
        this.textField.setText(this.textField.getText() + "(");
    }
}
