package org.example.server;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class IdFXMLController {

    @FXML
    private Button Tastiqlash;
    @FXML
    private TextField IdField;
    @FXML
    private AnchorPane rootPane;

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            IdField.requestFocus();  // TextFieldga fokusni qo'yish
            centerElements();  // Boshlang'ich markazlashtirish
        });

        Tastiqlash.setOnAction(event -> validateAndOpen());
        IdField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                validateAndOpen();
            }
        });

    }

    private void validateAndOpen() {
        if (IdField.getText().equals("15")) {
            openScene();
            System.out.println("Test Boshlandi");
        }
    }

    private void openScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/server/FORMA.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) Tastiqlash.getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            System.err.println("FXML faylni ochishda xatolik: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void centerElements() {
        double width = rootPane.getWidth();
        double height = rootPane.getHeight();

        // Element o'lchamlari
        double fieldWidth = 300; // TextField kengligi
        double fieldHeight = 40; // TextField balandligi
        double buttonWidth = 150; // Button kengligi
        double buttonHeight = 40; // Button balandligi

        // TextField markazda joylashuvi
        IdField.setPrefWidth(fieldWidth);
        IdField.setPrefHeight(fieldHeight);
        IdField.setLayoutX((width - fieldWidth) / 2);
        IdField.setLayoutY((height - fieldHeight) / 2 - 30); // Tugmadan biroz yuqoriga

        // Button markazda joylashuvi
        Tastiqlash.setPrefWidth(buttonWidth);
        Tastiqlash.setPrefHeight(buttonHeight);
        Tastiqlash.setLayoutX((width - buttonWidth) / 2);
        Tastiqlash.setLayoutY((height - buttonHeight) / 2 + 30); // TextFielddan pastga
    }
}
