package com.example.group_129will_hero;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainPageController implements Initializable{

        private Stage stage;
        private Scene scene;
//    private Parent root;

        @FXML
        private AnchorPane rootPane;

        @FXML
        private void settingButtonClick (ActionEvent event) {
            makeFadeOut();
        }

        @FXML
        private void PlayButtonClick(ActionEvent event) throws IOException {
            Parent secondView;
            secondView=(AnchorPane) FXMLLoader.load(getClass().getResource("midgame.fxml"));
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) rootPane.getScene().getWindow();
            curStage.setScene(newScene);
        }

        private void makeFadeOut() {
            FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(800));
            fadeOutTransition.setNode(rootPane);
            fadeOutTransition.setFromValue(1.0);
            fadeOutTransition.setToValue(0.0);
            fadeOutTransition.setOnFinished((ActionEvent event) -> {
                try {
                    loadNextScene();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fadeOutTransition.play();
        }

        @Override
        public void initialize(URL url, ResourceBundle rb){
            rootPane.setOpacity(0);
            makeFadeInTransition();
        }

        private void makeFadeInTransition() {
            FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000));
            fadeInTransition.setNode(rootPane);
            fadeInTransition.setFromValue(0.0);
            fadeInTransition.setToValue(1.0);

            fadeInTransition.play();
        }


        private void loadNextScene() throws IOException {
            Parent secondView;
            secondView=(AnchorPane) FXMLLoader.load(getClass().getResource("settings.fxml"));
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) rootPane.getScene().getWindow();
            curStage.setScene(newScene);
        }

    }

