package vsu.cg.tasks.engine.assets.simple_objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import vsu.cg.tasks.engine.baseFigures.Shape;

public class Water extends Shape {
    public Water(double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle(x,y,width,height);
        Color color = new Color(0.45,0.54,0.80,0.80);
        rectangle.setFill(color);
        holst.getChildren().addAll(rectangle);
    }
}
