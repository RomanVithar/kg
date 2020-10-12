package vsu.cg.tasks.engine.assets.simple_objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import vsu.cg.tasks.engine.services.SimpleDrawObject;

import java.util.ArrayList;

public class Cloud extends SimpleDrawObject {

    public Cloud(double centerX, double centerY, int size) {
        ArrayList<Circle> circles = new ArrayList<Circle>();
        for (int i = 0; i < (int) (Math.random() * 4 + 3); i++) {
            Circle circle = new Circle(Math.random() * size + 30);
            circle.setFill(Color.LIGHTBLUE);
            circle.setCenterX(centerX + 45 * i);
            circle.setCenterY(centerY);
            circles.add(circle);
        }
        holst.getChildren().addAll(circles);
    }
}
