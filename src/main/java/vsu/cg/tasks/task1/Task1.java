package vsu.cg.tasks.task1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vsu.cg.tasks.engine.assets.backgrounds.SeaBack;
import vsu.cg.tasks.engine.assets.simple_objects.Ship;
import vsu.cg.tasks.engine.assets.simple_objects.Sky;
import vsu.cg.tasks.engine.assets.simple_objects.Water;

public class Task1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1500, 900, Color.BLACK);
        SeaBack seaBack = new SeaBack(0, 0, 1500, 900);
        seaBack.putOnGroup(root);
        Ship ship = new Ship(500, 600, 600, 350);
        ship.putOnGroup(root);
        primaryStage.setTitle("task1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Task1.class, args);
    }
}
