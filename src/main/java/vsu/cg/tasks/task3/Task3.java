package vsu.cg.tasks.task3;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vsu.cg.tasks.engine.base_figures.Shape;
import vsu.cg.tasks.engine.base_figures.circle.Circle;
import vsu.cg.tasks.engine.base_figures.decart.Axes;
import vsu.cg.tasks.engine.base_figures.kurve.KurveBezier;
import vsu.cg.tasks.engine.base_figures.line.Line;
import vsu.cg.tasks.engine.base_figures.rectangle.Rectangle;
import vsu.cg.tasks.services.GlobalConstants;
import vsu.cg.tasks.services.InputHandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task3 extends Application {
    private Scene scene;
    private InputHandler inputHandler;
    private List<Shape> shapeList; // в него добавлять фигуры
    private Group root;
    private List<Rectangle> rectangles;
    private Integer x1 = null;
    private Integer y1 = null;
    private boolean isClicked;


    @Override
    public void init() throws Exception {
        super.init();
        shapeList = new LinkedList<>();
        root = new Group();
        scene = new Scene(root, GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT, Color.BLACK);
        inputHandler = new InputHandler();
        rectangles = new ArrayList<Rectangle>();
        isClicked = false;
    }

    @Override
    public void start(Stage primaryStage) {
        Axes axes = new Axes(root);
        shapeList.add(axes);
        axes.draw();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(isClicked){
                    Rectangle rectangle = new Rectangle(root, x1, (int)mouseEvent.getX(),y1,(int)mouseEvent.getY());
                    isClicked = false;
                    x1 = null;
                    y1 = null;
                    rectangle.translateCoord();
                    shapeList.add(rectangle);
                    rectangles.add(rectangle);
                    rectangle.draw();
                    task();
                }else{
                    x1 = (int)mouseEvent.getX();
                    y1 = (int)mouseEvent.getY();
                    isClicked = true;
                }
            }
        });

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

    private void task(){
        //inputHandler.render(shapeList);
        update();
        if(rectangles.size()<2){
            return;
        }
//        for(Shape shape:shapeList){
//            if(shape.isMarkRec()){
//                shape.clear();
//                shapeList.remove(shape);
//                rectangles.remove(shape);
//            }
//        }
        Rectangle rectangle = rectangles.get(0);
        for(int i=1;i<rectangles.size();i++){
            if(rectangle.getIntersection(rectangles.get(i))!=null) {
                rectangle = rectangle.getIntersection(rectangles.get(i));
            }
        }
        rectangle.setColor(Color.YELLOW);
        rectangle.setMarkRec(true);
        shapeList.add(rectangle);
        rectangle.draw();
    }
}

