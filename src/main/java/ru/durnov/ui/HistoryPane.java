package ru.durnov.ui;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ru.durnov.dao.DataBase;

import java.sql.SQLException;

public class HistoryPane extends VBox {
    private final DataBase dataBase;

    public HistoryPane(DataBase dataBase) throws SQLException {
        this.dataBase = dataBase;
        dataBase.expressionList().forEach(expression -> {
            this.getChildren().add(new )
        });
    }
}
