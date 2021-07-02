package ru.durnov;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.durnov.ui.Calculator;

import java.util.Objects;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Calculator());
        scene.getStylesheets().add(
                Objects
                        .requireNonNull(getClass().getResource("/application.css"))
                        .toExternalForm()
        );
        primaryStage.setScene(scene);
        primaryStage.setHeight(550);
        primaryStage.show();
    }
}
