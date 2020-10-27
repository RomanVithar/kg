package vsu.cg.tasks.task3;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vsu.cg.tasks.engine.baseFigures.circle.Circle;
import vsu.cg.tasks.engine.baseFigures.circle.circle_extends.CircleBresenham;
import vsu.cg.tasks.engine.baseFigures.line.Line;
import vsu.cg.tasks.engine.baseFigures.line.line_extends.LineBresenham;
import vsu.cg.tasks.engine.baseFigures.line.line_extends.LineWu;
import vsu.cg.tasks.engine.decart.Axes;
import vsu.cg.tasks.services.GlobalConstants;
import vsu.cg.tasks.services.InputHandler;

public class Task3 extends Application {
    private Axes axes;
    private Scene scene;
    private InputHandler inputHandler;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        axes = new Axes(root);
        scene = new Scene(root, GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT, Color.BLACK);
        axes.draw();
        inputHandler = new InputHandler();

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
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                inputHandler.camera(key,axes);
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(Task3.class, args);
    }
}

