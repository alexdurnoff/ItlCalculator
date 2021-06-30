package ru.durnov;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.durnov.ui.Calculator;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Calculator());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
