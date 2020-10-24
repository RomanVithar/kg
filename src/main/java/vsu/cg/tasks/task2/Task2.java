package vsu.cg.tasks.task2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vsu.cg.tasks.engine.baseFigures.circle.Circle;
import vsu.cg.tasks.engine.baseFigures.circle.circle_extends.CircleBresenham;
import vsu.cg.tasks.engine.baseFigures.line.Line;
import vsu.cg.tasks.engine.baseFigures.line.line_extends.LineWu;
import vsu.cg.tasks.services.GlobalConstants;


public class Task2 extends Application {
    private double x2=0;
    private double y2=0;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT, Color.BLACK);

        Line line = new LineWu(0, 0, x2, y2);
        Circle circle = new CircleBresenham(GlobalConstants.SCREEN_WIDTH/2, GlobalConstants.SCREEN_HEIGHT/2,100);

        circle.drawCircle();
        line.drawLine();
        line.setColor(Color.ALICEBLUE);

        circle.putOnGroup(root);
        line.putOnGroup(root);

        primaryStage.setTitle("task2");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                line.setY1(y2);
                line.setX1(x2);
                x2 = mouseEvent.getX();
                y2 = mouseEvent.getY();
                line.setY2(y2);
                line.setX2(x2);
                line.drawLine();
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(Task2.class, args);
    }
}
