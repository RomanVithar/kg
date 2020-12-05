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
import vsu.cg.tasks.engine.base_figures.Shape;
import vsu.cg.tasks.engine.base_figures.circle.Circle;
import vsu.cg.tasks.engine.base_figures.decart.Axes;
import vsu.cg.tasks.engine.base_figures.kurve.KurveBezier;
import vsu.cg.tasks.engine.base_figures.line.Line;
import vsu.cg.tasks.services.GlobalConstants;
import vsu.cg.tasks.services.InputHandler;

import java.util.LinkedList;
import java.util.List;

public class Task3 extends Application {
    private Scene scene;
    private InputHandler inputHandler;
    private List<Shape> shapeList;
    private Group root;

    @Override
    public void init() throws Exception {
        super.init();
        shapeList = new LinkedList<>();
        root = new Group();
        scene = new Scene(root, GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT, Color.BLACK);
        inputHandler = new InputHandler();

    }

    @Override
    public void start(Stage primaryStage) {
        Axes axes = new Axes(root);
        shapeList.add(axes);
//        Line line = new Line(root, 10, 10, 100, 100);
        Circle circle = new Circle(root, 300, 200, 50);
//        shapeList.add(line);
        shapeList.add(circle);
        axes.draw();
//        line.draw();
        circle.draw();

        KurveBezier kurveBezier = new KurveBezier(root);
        kurveBezier.addPoint(100,100);
        kurveBezier.addPoint(100,300);
        KurveBezier kurveBezier2 = new KurveBezier(root);
        kurveBezier2.addPoint(100,300);
        kurveBezier2.addPoint(200,300);
        kurveBezier2.addPoint(200,200);
        kurveBezier2.addPoint(100,200);


        shapeList.add(kurveBezier);
        shapeList.add(kurveBezier2);
        kurveBezier.draw();
        kurveBezier2.draw();

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
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                inputHandler.camera(key, shapeList);
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(Task3.class, args);
    }
}

