package ru.durnov.expressions;

import javafx.scene.control.TextField;

public class ExpressionString {
    private final String source;

    public ExpressionString(String source){
        this.source = new StringReplaceMultiplyDivide(
                new StringReplaceSQRT(
                        new StringReplacePower(
                                new StringReplaceBrackets(
                                        source
                                ).string()
                        ).string()
                ).string()
        ).string();

    }
    public ExpressionString(TextField textField) {
        this(textField.getText());
    }


    public String string(){
        return this.source;
    }
}
