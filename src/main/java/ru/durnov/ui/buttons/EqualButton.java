package ru.durnov.ui.buttons;

public class EqualButton implements CalculatorButton{
    private Double result;

    @Override
    public String addTo(String str) {
        if (this.result == null) return str;
        return String.valueOf(this.result);
    }

    public void setResult(double result){
        this.result = result;
    }
}
