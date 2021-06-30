package ru.durnov.ui.buttons;

import ru.durnov.expressions.Operator;

public class OperatorButton implements CalculatorButton{
    private final Operator operator;

    public OperatorButton(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String addTo(String str) {
        return str + this.operator.symbol();
    }
}
