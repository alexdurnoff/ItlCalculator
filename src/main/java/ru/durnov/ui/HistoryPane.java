package ru.durnov.ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ru.durnov.dao.DataBase;


import java.sql.SQLException;

public class HistoryPane extends VBox {
    private final DataBase dataBase;

    public HistoryPane(DataBase dataBase) throws SQLException {
        this.dataBase = dataBase;
        dataBase.expressionList().forEach(expression -> {
            TextField textField = new TextField(expression.toString());
            textField.setEditable(false);
            this.getChildren().add(textField);
        });
        this.setSpacing(5);
        this.setWidth(300);
    }
}
