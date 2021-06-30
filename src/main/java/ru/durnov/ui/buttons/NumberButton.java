package ru.durnov.ui.buttons;

import javafx.scene.control.Button;

public class NumberButton extends Button implements CalculatorButton{
    private final Integer number;

    public NumberButton(Integer number) {
        this.number = number;
    }


    @Override
    public String addTo(String str) {
        return str + String.valueOf(this.number);
    }
}
