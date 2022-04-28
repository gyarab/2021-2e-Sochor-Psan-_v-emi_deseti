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

import java.util.Random;
import java.util.Objects;


public class TrenovaniController {
    String text;
    @FXML
    Button btn8;
    @FXML
    Button btn3;
    @FXML
    Button btn6;
    @FXML
    Button btn7;
    @FXML
    Label score1;

    @FXML
    //tlačítko zpět
    public void onButtonClick3() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage window = (Stage) btn3.getScene().getWindow();
        window.setScene(new Scene(root, 1550, 800));

    }

    @FXML
    //tlačítko novy text
    public void onButtonClick6() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("train.fxml")));
        Stage window = (Stage) btn6.getScene().getWindow();
        window.setScene(new Scene(root, 1550, 800));
        window.setScene(new Scene(root1, 1550, 800));

    }

    boolean skore = true;

    @FXML
    //tlačítko score
    public void onButtonClick7() throws Exception {
        if (skore) {
            score1.setText("Skore: " + chyba + t);
        }

    }

    @FXML
    TextArea psani;

    @FXML
    TextArea txt1;

    //FIXME text k opsani
    //TODO tlacito text generace v budoucnu
    public void onButtonClick8() throws Exception {

    }

//    Dalo by se pridat vyber generace v budoucnu
//    int leLimit = 97; // pismeno 'a'
//    int riLimit = 122; // pismeno 'z'
//    int delka1 = 7;
//    int delka2 = 4;
//    Random random = new Random();

    // String text3 = String.valueOf(random.ints());

//    String text1 = random.ints(leLimit, riLimit + 1).limit(delka1)
//            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//            .toString();
//    String text2 = random.ints(leLimit, riLimit + 1).limit(delka2)
//            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//            .toString();

    //String text = text1 + text2;
    //Test text fff
    // String text = "fff";

    int chyba = 0;
    int ll = 0;

    public void onClick1() throws Exception {
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
    Label cas1;
    @FXML
    Label chyb1;


    int t = 0;
    boolean klik = true;
    boolean stop = true;
    boolean rest = true;

    public void onMouseClicked1() throws Exception {
        Random rn = new Random();
        int odpoved = rn.nextInt(7) + 1;
        System.out.println(odpoved);
        switch (odpoved) {
            case 1:
                text = "Jak vlastně vypadají ony balónky?. Ptají se často lidé.";;
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
        stop = true;
        if (rest) {
            txt1.setText(text);
            rest = false;
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


    public void onKey1() {
        cas1.setText("konec");

    }


}












