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
import vsu.cg.tasks.services.GlobalConstants;

public class Task1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT, Color.BLACK);
        SeaBack seaBack = new SeaBack(0, 0, GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT);
        seaBack.putOnGroup(root);
        Ship ship = new Ship(200, 400, 400, 150);
        ship.putOnGroup(root);
        primaryStage.setTitle("task1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Task1.class, args);
    }
}
