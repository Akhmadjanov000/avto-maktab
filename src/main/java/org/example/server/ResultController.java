package org.example.server;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class ResultController {

    private int correctAnswersCount;

    public void setCorrectAnswersCount(int correctAnswersCount) {
        this.correctAnswersCount = correctAnswersCount;
    }

    @FXML
    private Button idLabel;
    @FXML
    private Button ismLabel;
    @FXML
    private Button famLabel;
    @FXML
    private Button qaytish;
    @FXML
    public Button button;

    @FXML
    private void initialize() {
        button.setText("Correct Answers: " + correctAnswersCount);
        qaytish.setOnAction(actionEvent -> openScene("/org/example/server/Welcome.fxml"));
        idLabel.setText("id");
        ismLabel.setText("Ism");
        famLabel.setText("fam");
        qaytish.setText("Tugatish!");
    }

    private void openScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            if (stage != null) {
                stage.close();
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.show();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
