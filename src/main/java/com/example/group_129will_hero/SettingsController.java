package com.example.group_129will_hero;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable{
    @FXML
    private AnchorPane rootPane;
//    @FXML
//    ImageView sound;
//    @FXML
//    ImageView music;
//    @FXML
//    Button sb;
//    @FXML
//    Button mb;
    @FXML
    private void crossButtonClick (ActionEvent event) throws IOException {
        makeFadeOut();
    }
//    Image myImage = new Image(getClass().getResourceAsStream("sound.jpeg"));
//    Image myImage1 = new Image(getClass().getResourceAsStream("music.jpeg"));
//
//    public void displaySoundImage() {
//        sound.setImage(myImage);
//    }
//    public void displayMusicImage() {
//        music.setImage(myImage1);
//    }


    @Override
    public void initialize(URL url, ResourceBundle rb){
        rootPane.setOpacity(0);
        makeFadeInTransition();
    }

    private void makeFadeInTransition() {
        FadeTransition fadeInTransition = new FadeTransition(Duration.millis(800));
        fadeInTransition.setNode(rootPane);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);

        fadeInTransition.play();
    }

    private void loadNextScene() throws IOException {
        Parent secondView;
        secondView=(AnchorPane) FXMLLoader.load(getClass().getResource("MainPage.fxml"));
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
}

