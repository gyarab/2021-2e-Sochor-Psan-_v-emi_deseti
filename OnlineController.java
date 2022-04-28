package com.example.rocnikovka;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;


public class OnlineController {

    @FXML
    Button btn7;
    @FXML
    Label score1;
    @FXML
    Label cas1;
    @FXML
    TextArea txt1;
    @FXML
    TextArea psani;
    @FXML
    Button btn4;

    static String text;


    @FXML
    //tlačítko zpět
    public void onButtonClick4() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) btn4.getScene().getWindow();
        window.setScene(new Scene(root, 1550, 800));


    }

    boolean skore = true;

    @FXML
    //tlačítko pripoj se kkt
    public void onButtonClick7() throws Exception {
        Socket socket = new Socket("142.132.174.213", 27513);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = in.readLine();
        System.out.println(request);
        int cislicko = Integer.parseInt(request);
        switch (cislicko) {
            case 1:
                text = "Jak vlastně vypadají ony balónky?. Ptají se často lidé.";
                break;
            case 2:
                text = "Vítr skoro nefouká a tak by se na první pohled mohlo zdát.";
                break;
            case 3:
                text = "Bůh viděl, že světlo je dobré, a Bůh oddělil světlo od tmy.";
                break;
            case 4:
                text = "Jenom tak klidně levitují ve vzduchu.";
                break;
            case 5:
                text = "Když svítí slunce tak silně jako nyní.";
                break;
            case 6:
                text = "Ploďte a množte se a naplňte vody v mořích.";
                break;
            case 7:
                text = "Bůh viděl všechno, co učinil, a hle, bylo to velmi dobré!";
                break;

        }
        System.out.println(text);


        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("HTTP/1.0 200");


    }


    int chyba = 0;
    int ll = 0;

    public void onClick1() throws Exception {
        System.out.println(psani.getText());
        System.out.println(text);
        try {
            System.out.println(psani.getText().equals(text.substring(0, (psani.getLength()))));
            if (psani.getText().equals(text.substring(0, (psani.getLength())))) {
                System.out.println("dobre");
                if (psani.getLength() == text.length() - 1) {
                    stop = false;
                    System.out.println("spravně");
                }

            } else {
                if (!(ll > psani.getLength())) {
                    chyba++;
                    chyb1.setText("Počet chyb: " + chyba);
                    System.out.println(chyba + " chyb");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            if (!(ll > psani.getLength())) {
                chyba++;
                chyb1.setText("Počet chyb: " + chyba);
                System.out.println(chyba + " chyb");
            }
        }

        if (psani.getText().equals(text)) {
            skore = false;
            stop = false;

        }
        ll = psani.getLength();
    }


    @FXML
    Label chyb1;


    int t = 0;
    boolean klik = true;
    boolean stop = true;
    boolean rest = true;

    public void onMouseClicked1() throws Exception {
        if (rest) {
            txt1.setText(text);
           // rest = false;
        }
        if (klik) {
            klik = false;
            int wait = 1000;
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    Runnable updater = new Runnable() {

                        @Override
                        public void run() {
                            stop = true;
                            if (stop) t++;
                            cas1.setText("čas " + t + " sekund");
                        }
                    };

                    while (true) {
                        try {
                            Thread.sleep(wait);
                        } catch (InterruptedException ex) {
                        }
                        Platform.runLater(updater);
                    }
                }


            });

            thread.setDaemon(true);
            thread.start();
        }

    }

    @FXML
    Button btn5;

    //tlacitko ready
    public void onButtonClick5() {
        t = 0;
        chyba = 0;
        chyb1.setText("Počet chyb: 0");
        psani.setText("");
        txt1.setText("");
        score1.setText("");
        rest = true;
        skore = true;

    }

    //nic nedela
    public void onKey1() {
        cas1.setText("konec");

    }


}



