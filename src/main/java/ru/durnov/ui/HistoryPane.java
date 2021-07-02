package ru.durnov.ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ru.durnov.dao.DataBase;


import java.sql.SQLException;

public class HistoryPane extends VBox {
    private final DataBase dataBase;

    public HistoryPane(DataBase dataBase) throws SQLException {
        this.dataBase = dataBase;
        dataBase.expressionList().forEach(expression -> {
            TextField textField = new TextField(expression.getExpression() +
                    "=" + String.format("%.4f", expression.getResult()));
            textField.setEditable(false);
            this.getChildren().add(textField);
        });
        this.setSpacing(5);
        this.setWidth(300);
    }

    public void refresh(){
        this.getChildren().clear();
        this.fill();
    }

    private void fill() {
        try {
            dataBase.expressionList().forEach(expression -> {
                TextField textField = new TextField(expression.getExpression() +
                        "=" + String.format("%.4f", expression.getResult()));
                textField.setEditable(false);
                this.getChildren().add(textField);
            });
        } catch (Exception exception) {
            try {
                Thread.sleep(500);
                fill();
            } catch (InterruptedException ignored) {

            }
        }
    }
}
