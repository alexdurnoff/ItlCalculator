package ru.durnov.ui;

import javafx.scene.layout.GridPane;
import ru.durnov.dao.DataBase;

public class CalculatorPane extends GridPane {
    private final DataBase dataBase;

    public CalculatorPane(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
