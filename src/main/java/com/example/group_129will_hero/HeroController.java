package com.example.group_129will_hero;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.shape.hero;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class HeroController implements Initializable{

        @FXML
        private AnchorPane scene;
        @FXML
        private ImageView hero;
        @FXML
        private ImageView orc;
        @FXML
        private ImageView orc1;
        @FXML
        private ImageView orc2;
        @FXML
        private ImageView monster;
        @FXML
        private ImageView i3;
        @FXML
        private ImageView pillar;
        @FXML
        private ImageView i1;
        @FXML
        private ImageView t1;
        @FXML
        private ImageView t2;


    @FXML
    private void settingButtonClick (ActionEvent event) throws IOException {
        Parent secondView;
        secondView=(AnchorPane) FXMLLoader.load(getClass().getResource("GameSettings.fxml"));
        Scene newScene = new Scene(secondView);
        Stage curStage = (Stage) scene.getScene().getWindow();
        curStage.setScene(newScene);
    }
        //1 Frame evey 10 millis, which means 100 FP
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(40), new EventHandler<ActionEvent>() {

            double deltaY = -3;

            double monsterY = -2;

            @Override
            public void handle(ActionEvent actionEvent) {
                double y = hero.getY();

                hero.setX(hero.getX());
                hero.setY(hero.getY() + deltaY);
//            hero.setLayoutY(hero.getLayoutY() - deltaY);


                Bounds bounds = scene.getBoundsInLocal();
//                boolean rightBorder = hero.getLayoutX() >= (bounds.getMaxX() - hero.getRadius());
//                boolean leftBorder = hero.getLayoutX() <= (bounds.getMinX() + hero.getRadius());
                boolean bottomBorder = hero.getY() >= (y+100);
                boolean topBorder = hero.getY() <= (y);

                if (hero.getY() == -36 || hero.getY() == 0) {
                    deltaY *= -1;
                }

                double Y = monster.getY();

                monster.setX(monster.getX());
                monster.setY(monster.getY() + monsterY);
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

                if (monster.getY() == -16 || monster.getY() == 0) {
                    monsterY *= -1;
                }


            }
        }));

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(40), new EventHandler<ActionEvent>() {
            double deltaOrcY = -2;
            double deltaOrc1Y = -2;
            double deltaOrc2Y = -2;

            @Override
            public void handle(ActionEvent actionEvent) {
                double y1 = orc.getY();

                orc.setX(orc.getX());
                orc.setY(orc.getY() + deltaOrcY);
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

                if (orc.getY() == -36 || orc.getY() == 0) {
                    deltaOrcY *= -1;
                }

                double y2 = orc1.getY();

                orc1.setX(orc1.getX());
                orc1.setY(orc1.getY() + deltaOrc1Y);
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

                if (orc1.getY() == -32 || orc1.getY() == 0) {
                    deltaOrc1Y *= -1;
                }

                double y3 = orc2.getY();

                orc2.setX(orc2.getX());
                orc2.setY(orc2.getY() + deltaOrc2Y);
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

                if (orc2.getY() == -32 || orc2.getY() == 0) {
                    deltaOrc2Y *= -1;
                }
            }
        }));
    Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(150), new EventHandler<ActionEvent>() {
            double i3y = -1;
            double pillarY = -1;

        @Override
        public void handle(ActionEvent actionEvent) {
            double y1 = i3.getY();

            i3.setX(i3.getX());
            i3.setY(i3.getY() + i3y);
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

            if (i3.getY() == -16 || i3.getY() == 0) {
                i3y *= -1;
            }

            double y2 = pillar.getY();

            pillar.setX(pillar.getX());
            pillar.setY(pillar.getY() + pillarY);
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

            if (pillar.getY() == -16 || pillar.getY() == 0) {
                pillarY *= -1;
            }
        }
    }));
    Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(150), new EventHandler<ActionEvent>() {
        double i1x = -0.5;
        double t1x = -0.5;
        double t2x = -0.5;

        @Override
        public void handle(ActionEvent actionEvent) {
            double x1 = i1.getX();

            i1.setX(i1.getX() + i1x);
            i1.setY(i1.getY());
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

            if (i1.getX() == -10 || i1.getX() == 0) {
                i1x *= -1;
            }

            double x2 = t1.getX();

            t1.setX(t1.getX()+t1x);
            t1.setY(t1.getY());
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

            if (t1.getX() == -10 || t1.getX() == 0) {
                t1x *= -1;
            }
            double x3 = t2.getX();

            t2.setX(t2.getX()+t2x);
            t2.setY(t2.getY());
//            hero.setLayoutY(hero.getLayoutY() - deltaY);

            if (t2.getX() == -10 || t2.getX() == 0) {
                t2x *= -1;
            }

        }
    }));



        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline2.setCycleCount(Animation.INDEFINITE);
            timeline3.setCycleCount(Animation.INDEFINITE);
//        new PauseTransition(Duration.millis(20));
//        hero.setTranslateY(hero.getTranslateY() + 70);
            timeline.play();
            timeline1.play();
            timeline2.play();
            timeline3.play();
        }
    }
