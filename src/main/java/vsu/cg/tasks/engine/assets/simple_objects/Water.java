package vsu.cg.tasks.engine.assets.simple_objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import vsu.cg.tasks.engine.services.SimpleDrawObject;

public class Water extends SimpleDrawObject {
    public Water(int x, int y, int width, int height) {
        Rectangle rectangle = new Rectangle(x,y,width,height);
        Color color = new Color(0.45,0.54,0.80,0.80);
        rectangle.setFill(color);
        holst.getChildren().addAll(rectangle);
    }
}
