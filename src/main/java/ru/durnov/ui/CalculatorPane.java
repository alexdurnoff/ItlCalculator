package ru.durnov.ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.durnov.dao.DataBase;
import ru.durnov.expressions.ArithmeticOperator;
import ru.durnov.ui.controls.*;

public class CalculatorPane extends VBox {
    private final DataBase dataBase;
    private final TextField textField = new CalcField();
    private final NumberButton button0 = new NumberButton(0, this.textField);
    private final NumberButton button1 = new NumberButton(1, this.textField);
    private final NumberButton button2 = new NumberButton(2, this.textField);
    private final NumberButton button3 = new NumberButton(3, this.textField);
    private final NumberButton button4 = new NumberButton(4, this.textField);
    private final NumberButton button5 = new NumberButton(5, this.textField);
    private final NumberButton button6 = new NumberButton(6, this.textField);
    private final NumberButton button7 = new NumberButton(7, this.textField);
    private final NumberButton button8 = new NumberButton(8, this.textField);
    private final NumberButton button9 = new NumberButton(9, this.textField);
    private final OperatorButton buttonPlus = new OperatorButton(ArithmeticOperator.PLUS, this.textField);
    private final OperatorButton buttonMinus = new OperatorButton(ArithmeticOperator.MINUS, this.textField);
    private final OperatorButton buttonMultiply = new OperatorButton(ArithmeticOperator.MULTIPLY, this.textField);
    private final OperatorButton buttonDivide = new OperatorButton(ArithmeticOperator.DIVIDE, this.textField);
    private final OperatorButton buttonSQRT = new OperatorButton(ArithmeticOperator.SQRT, this.textField);
    private final OperatorButton buttonPower = new OperatorButton(ArithmeticOperator.POWER, this.textField);
    private final EqualButton equalButton;
    private final CancelButton cancelButton = new CancelButton(this.textField);
    private final OpenBracketButton openBracketButton = new OpenBracketButton(this.textField);
    private final CloseBracketButton closeBracketButton = new CloseBracketButton(this.textField);

    public CalculatorPane(DataBase dataBase) {
        this.dataBase = dataBase;
        this.equalButton = new EqualButton(this.textField, this.dataBase);

        this.getChildren().add(this.textField);
        this.getChildren().add(new HBox(button1, button2, button3, button4));
        this.getChildren().add(new HBox(button5, button6, button7, button8));
        this.getChildren().add(new HBox(button9, buttonPlus, buttonMinus, buttonMultiply));
        this.getChildren().add(new HBox(button0, buttonDivide, buttonPower, buttonSQRT));
        this.getChildren().add(new HBox(openBracketButton, closeBracketButton,cancelButton, equalButton));

    }

    public EqualButton equalButton(){
        return this.equalButton;
    }


}
