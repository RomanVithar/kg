package vsu.cg.tasks.task3;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vsu.cg.tasks.engine.decart.Axes;
import vsu.cg.tasks.services.GlobalConstants;

public class Task3 extends Application {
    private Axes axes = new Axes();

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT, Color.BLACK);
        axes.draw();
        axes.putOnGroup(root);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
        primaryStage.setTitle("task3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void update() {

    }

    public static void main(String[] args) {
        Application.launch(Task3.class, args);
    }
}

