package vsu.cg.tasks.task2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vsu.cg.tasks.engine.baseFigures.arch.Arch;
import vsu.cg.tasks.engine.baseFigures.arch.arch_extends.ArchBresenham;
import vsu.cg.tasks.engine.baseFigures.circle.Circle;
import vsu.cg.tasks.engine.baseFigures.circle.circle_extends.CircleBresenham;
import vsu.cg.tasks.engine.baseFigures.circle.circle_extends.CirclePie;
import vsu.cg.tasks.engine.baseFigures.ellipse.Ellipse;
import vsu.cg.tasks.engine.baseFigures.ellipse.ellipse_extends.EllipseBresenham;
import vsu.cg.tasks.engine.baseFigures.ellipse.ellipse_extends.FillEllipse;
import vsu.cg.tasks.engine.baseFigures.line.Line;
import vsu.cg.tasks.engine.baseFigures.line.line_extends.LineWu;
import vsu.cg.tasks.engine.decart.Axes;
import vsu.cg.tasks.services.GlobalConstants;

import java.util.ArrayList;


public class Task2 extends Application {
    private double x2=0;
    private double y2=0;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, GlobalConstants.SCREEN_WIDTH, GlobalConstants.SCREEN_HEIGHT, Color.BLACK);

        Line line = new LineWu(root,0, 0, x2, y2);
        Circle circle = new CircleBresenham(root,GlobalConstants.SCREEN_WIDTH/2, GlobalConstants.SCREEN_HEIGHT/2,100);
        Ellipse ellipse = new EllipseBresenham(root,GlobalConstants.SCREEN_WIDTH/2,
                GlobalConstants.SCREEN_HEIGHT/2,200,101);
        Arch arch = new ArchBresenham(root,GlobalConstants.SCREEN_WIDTH/2,
                GlobalConstants.SCREEN_HEIGHT/2,
                200,
                300);
        Ellipse fillEllipse = new FillEllipse(root,GlobalConstants.SCREEN_WIDTH/2,
                GlobalConstants.SCREEN_HEIGHT/2+200, 100,50);
        CirclePie circlePie = new CirclePie(root,GlobalConstants.SCREEN_WIDTH/2+350,
                GlobalConstants.SCREEN_HEIGHT/2-200, 100);
        ArrayList<Integer> sectors = new ArrayList<>();
        sectors.add(160);
        sectors.add(80);
        sectors.add(40);
        sectors.add(20);
        sectors.add(10);
        sectors.add(5);
        circlePie.setListPie(sectors);

        circlePie.draw();
        fillEllipse.setColor(Color.DARKGOLDENROD);
        fillEllipse.draw();
        arch.setColor(Color.CORNSILK);
        arch.draw();
        ellipse.setColor(Color.CHARTREUSE);
        ellipse.draw();
        circle.draw();
        line.draw();
        line.setColor(Color.ALICEBLUE);

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
                line.draw();
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(Task2.class, args);
    }
}
