package ru.durnov.expressions;

import javafx.scene.control.TextField;

public class ExpressionString {
    private final String resultString;
    private final String source;

    public ExpressionString(String sourceString){
        this.source = sourceString;
        this.resultString = new StringReplaceMultiplyDivide(
                new StringReplaceSQRT(
                        new StringReplacePower(
                                new StringReplaceBrackets(
                                        sourceString.replace(',', '.')
                                ).string()
                        ).string()
                ).string()
        ).string()
                .replace("--", "+")
                .replace("+-", "-");

    }
    public ExpressionString(TextField textField) {
        this(textField.getText());
    }


    public String string(){
        return this.resultString;
    }

    public String source(){
        return this.source;
    }
}
