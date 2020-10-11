package vsu.cg.tasks.engine.assets.simple_objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import vsu.cg.tasks.engine.assets.SimpleDrawObject;

public class Sky extends SimpleDrawObject {
    private Rectangle rectangle;

    public Sky(int x, int y, int width, int height) {
        rectangle = new Rectangle(x,y,width,height);
        rectangle.setFill(Color.GREY );
        holst.getChildren().addAll(rectangle);
        for(int i=0;i<1+Math.random()*(width/200);i++) {
            Cloud cloud = new Cloud(Math.random()*width, 70+Math.random()*200, (int)(20+Math.random()*20));
            cloud.putOnGroup(holst);
        }
    }
}
