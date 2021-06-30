package ru.durnov.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import ru.durnov.dao.DataBase;
import ru.durnov.dao.ExpressionDao;

import java.sql.SQLException;

public class Calculator extends GridPane {
    private final CalculatorPane calculatorPane;
    private final DataBase dataBase;
    private final Button historyButton = new Button();

    public Calculator() throws SQLException {
        this.dataBase = new ExpressionDao();
        this.calculatorPane = new CalculatorPane(this.dataBase);
        hideHistory();
    }

    public void hideHistory(){
        this.historyButton.setOnAction(ae -> {
            try {
                showHistory();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
        this.getChildren().clear();
        this.historyButton.setText("Показать историю операций");
        this.setWidth(650);
        this.add(this.calculatorPane,0, 1);
        this.add(this.historyButton, 0, 0);
    }

    public void showHistory() throws SQLException {
        this.historyButton.setOnAction(ae -> hideHistory());
        this.getChildren().clear();
        this.historyButton.setText("Скрыть историю операций");
        this.setWidth(1300);
        this.add(this.historyButton, 0, 0);
        this.add(this.calculatorPane, 0, 1);
        this.add(new HistoryPane(this.dataBase), 1, 1);
    }
}
