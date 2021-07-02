package ru.durnov.exception;

import javafx.scene.control.Alert;

public class CalcAlert extends Alert {
    private final Exception exception;


    public CalcAlert(Exception exception, String header, String content) {
        super(AlertType.ERROR, content);
        this.exception = exception;
        this.setResizable(true);
        this.setHeaderText(header);
    }
}
