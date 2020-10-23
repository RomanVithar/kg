package vsu.cg.tasks.task2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vsu.cg.tasks.engine.baseFigures.Line;
import vsu.cg.tasks.engine.baseFigures.LineBresenham;
import vsu.cg.tasks.engine.baseFigures.LineDDA;
import vsu.cg.tasks.engine.baseFigures.LineWu;


public class Task2 extends Application {
    double x1 =0, x2=0, y1=0, y2=0;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 900, Color.BLACK);

        Line line = new LineWu(x1, y1, x2, y2);

        line.drawLine();
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
