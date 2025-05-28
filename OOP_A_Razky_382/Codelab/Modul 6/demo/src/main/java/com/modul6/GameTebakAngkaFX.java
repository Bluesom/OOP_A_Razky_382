package com.modul6;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameTebakAngkaFX extends Application {

    private int angkaRahasia;
    private int jumlahTebakan;
    private int batasAtas = 100;
    private final Random acak = new Random();

    @Override
    public void start(Stage panggungUtama) {
        Label judulLabel = new Label("🎮 Tebak Angka Rahasia");
        judulLabel.setFont(new Font("Arial", 24));
        judulLabel.setStyle("-fx-text-fill:rgb(44, 62, 80);");

        ComboBox<String> comboKesulitan = new ComboBox<>();
        comboKesulitan.getItems().addAll("Easy (1–50)", "Medium (1–100)", "Hard (1–200)");
        comboKesulitan.setPrefWidth(150);

        TextField inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan tebakan...");
        inputTebakan.setPrefWidth(200);

        Button tombolTebak = new Button("Coba Tebak");
        tombolTebak.setStyle("-fx-background-color:rgb(52, 152, 219); -fx-text-fill: white;");
        tombolTebak.setOnMouseEntered(e -> tombolTebak.setStyle("-fx-background-color:rgb(41, 127, 185); -fx-text-fill: white;"));
        tombolTebak.setOnMouseExited(e -> tombolTebak.setStyle("-fx-background-color:rgb(52, 152, 219); -fx-text-fill: white;"));

        Label labelFeedback = new Label();
        labelFeedback.setFont(new Font(14));
        Label labelJumlahTebakan = new Label("Total Tebakan: 0");

        HBox boxKesulitan = new HBox(10, new Label("Kesulitan:"), comboKesulitan);
        boxKesulitan.setAlignment(Pos.CENTER);

        HBox boxInput = new HBox(10, inputTebakan, tombolTebak);
        boxInput.setAlignment(Pos.CENTER);

        Separator separator = new Separator();

        VBox root = new VBox(20, judulLabel, boxKesulitan, separator, boxInput, labelFeedback, labelJumlahTebakan);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));
        root.setStyle("-fx-background-color:rgb(236, 240, 241);");

        comboKesulitan.setOnAction(e -> {
            String pilihan = comboKesulitan.getValue();
            switch (pilihan) {
                case "Easy (1–50)":
                    batasAtas = 50;
                    break;
                case "Medium (1–100)":
                    batasAtas = 100;
                    break;
                case "Hard (1–200)":
                    batasAtas = 200;
                    break;
            }
            mulaiGameBaru(labelFeedback, labelJumlahTebakan);
        });

        mulaiGameBaru(labelFeedback, labelJumlahTebakan);
        setupGuessHandler(tombolTebak, inputTebakan, labelFeedback, labelJumlahTebakan);

        Scene scene = new Scene(root, 500, 300);
        panggungUtama.setTitle("Mini Game: Tebak Angka");
        panggungUtama.setScene(scene);
        panggungUtama.show();
    }

    private void mulaiGameBaru(Label feedback, Label counter) {
        angkaRahasia = acak.nextInt(batasAtas) + 1;
        jumlahTebakan = 0;
        feedback.setText("Tebak angka dari 1 sampai " + batasAtas);
        feedback.setStyle("-fx-text-fill: black;");
        counter.setText("Total Tebakan: 0");
    }

    private void setupGuessHandler(Button tombolTebak, TextField inputTebakan, Label labelFeedback, Label labelJumlahTebakan) {
        tombolTebak.setOnAction(e -> {
            String masukan = inputTebakan.getText();
            try {
                int tebakan = Integer.parseInt(masukan);
                jumlahTebakan++;
                labelJumlahTebakan.setText("Total Tebakan: " + jumlahTebakan);

                if (tebakan < angkaRahasia) {
                    labelFeedback.setText("Terlalu kecil! Coba lebih besar.");
                    labelFeedback.setStyle("-fx-text-fill:rgb(0, 119, 204);");
                } else if (tebakan > angkaRahasia) {
                    labelFeedback.setText("Terlalu besar! Coba lebih kecil.");
                    labelFeedback.setStyle("-fx-text-fill:rgba(204, 102, 0, 0.72);");
                } else {
                    labelFeedback.setText("Tebakan kamu benar! Angka: " + angkaRahasia);
                    labelFeedback.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    tombolTebak.setText("Main Lagi");

                    tombolTebak.setOnAction(ev -> {
                        mulaiGameBaru(labelFeedback, labelJumlahTebakan);
                        tombolTebak.setText("Coba Tebak");
                        inputTebakan.clear();
                        setupGuessHandler(tombolTebak, inputTebakan, labelFeedback, labelJumlahTebakan);
                    });
                }
            } catch (NumberFormatException ex) {
                labelFeedback.setText("Masukkan angka yang valid!");
                labelFeedback.setStyle("-fx-text-fill: red;");
            }
            inputTebakan.clear();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}