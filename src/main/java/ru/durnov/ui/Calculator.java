package ru.durnov.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.hibernate.exception.LockAcquisitionException;
import ru.durnov.dao.DataBase;
import ru.durnov.dao.ExpressionDataBase;
import ru.durnov.exception.CalcAlert;

import java.sql.SQLException;

public class Calculator extends GridPane {
    private final DataBase dataBase;
    private final Button historyButton = new Button();
    private final HBox hBox;
    private final CalculatorPane calculatorPane;
    private final HistoryPane historyPane;

    public Calculator() throws SQLException {
        this.dataBase = new ExpressionDataBase();
        this.setWidth(360);
        this.historyButton.setOnAction(ae-> showHistory());
        this.hBox = new HBox(historyButton);
        this.hBox.setId("hist");
        this.setAlignment(Pos.BASELINE_CENTER);
        this.calculatorPane = new CalculatorPane(this.dataBase);
        this.historyPane = new HistoryPane(this.dataBase);
        this.historyButton.setText("Показать историю операций");
        this.add(this.hBox, 0, 0);
        this.add(calculatorPane,0, 1);
    }

    public void hideHistory(){
        this.sceneProperty().get().getWindow().setWidth(360);
        this.setWidth(360);
        this.historyButton.setOnAction(ae -> showHistory());
        this.getChildren().clear();
        this.historyButton.setText("Показать историю операций");
        this.add(this.hBox, 0, 0);
        this.add(calculatorPane,0, 1);
        this.calculatorPane.equalButton().setOnAction(ae -> calculatorPane.equalButton().addToTextField());
    }

    public void showHistory(){
        this.historyPane.refresh();
        this.sceneProperty().get().getWindow().setWidth(720);
        this.setWidth(720);
        this.historyButton.setOnAction(ae -> hideHistory());
        this.getChildren().clear();
        this.historyButton.setText("Скрыть историю операций");
        this.add(this.hBox, 0, 0);
        this.add(calculatorPane, 0, 1);
        this.add(historyPane, 1, 1);
        this.calculatorPane.equalButton().setOnAction(ae -> {
            this.calculatorPane.equalButton().addToTextField();
            this.historyPane.refresh();
        });
    }
}
