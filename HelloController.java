package com.example.rocnikovka;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloController {
    @FXML
    private Label Hlavnímenu;
    @FXML
    ProgressBar nacitac1;
    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button load1;

    @FXML
    public void onButtonClick1() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("train.fxml")));
        Stage window = (Stage) btn1.getScene().getWindow();
        window.setScene(new Scene(root, 1550, 800));


    }

    @FXML
    public void onButtonClick2() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("online.fxml")));
        Stage window = (Stage) btn2.getScene().getWindow();
        window.setScene(new Scene(root, 1550, 800));


    }

    int bar = 0;

    public void onLoad1() throws Exception {

        bar += 10;
        nacitac1.setProgress(bar / 100f);
        nacitac1.setProgress(Math.random());
    }

}