package ru.durnov.expressions;

import javafx.scene.control.TextField;

public class ExpressionString {
    private final TextField textField;
    private final String source;

    public ExpressionString(TextField textField) {
        this.textField = textField;
        this.source = new StringReplaceMultiplyDivide(
                new StringReplaceSQRT(
                        new StringReplacePower(
                                new StringReplaceBrackets(
                                        this.textField.getText()
                                ).string()
                        ).string()
                ).string()
        ).string();
    }

    public String string(){
        return this.source;
    }
}
