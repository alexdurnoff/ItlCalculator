package ru.durnov.expressions;

public class BracketNumber implements Number{
    private final double result;

    public BracketNumber(String str){
        if ((!str.startsWith("(")) && !(str.endsWith(")"))) throw new IllegalStateException("Illegal expression");
        String newString = str.replace("(", "").replace(")", "");
        if (newString.contains("(")) {
            this.result = new ArithmeticExpression(
                    new StringReplaceBrackets(newString).string()
            ).result();
        } else {
            this.result = new Result(
                    new StringReplacePower(
                            new StringReplaceSQRT(
                                    new StringReplaceMultiplyDivide(newString).string()
                            ).string()
                    ).string()
            ).result();
        }
    }

    @Override
    public double value() {
        return this.result;
    }
}
