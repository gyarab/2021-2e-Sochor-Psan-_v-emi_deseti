package com.example.rocnikovka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        primarystage.setTitle("Psaní všema deseti");
        primarystage.setScene(new Scene (root, 1550, 800));
        primarystage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}