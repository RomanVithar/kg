package vsu.cg.tasks.engine.assets.simple_objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import vsu.cg.tasks.engine.assets.SimpleDrawObject;

public class Ship extends SimpleDrawObject {
    public Ship(double x,double y, double width, double height) {
        Polygon body = new Polygon();
        body.getPoints().addAll(x+width/6,y,
                x+width/3*2, y,
                x+width/6*5, y-height/3,
                x, y-height/3);
        body.setFill(new Color(0.9,0.5,0.1,0.7));
        Rectangle mast = new Rectangle(x+width/2,y-height,width/50,height/3*2);
        Rectangle mast2 = new Rectangle(x+width/3,y-height/6*5,width/50,height/4*2);
        Rectangle mast3 = new Rectangle(x+width/3*2,y-height/6*5,width/50,height/4*2);
        Rectangle mast4 = new Rectangle(x+width/6,y-height/3*2,width/50,height/6*2);
        mast.setFill(new Color(0.4,0.2,0.03,0.8));
        mast2.setFill(new Color(0.4,0.2,0.03,0.8));
        mast3.setFill(new Color(0.4,0.2,0.03,0.8));
        mast4.setFill(new Color(0.4,0.2,0.03,0.8));
        Polygon sail = new Polygon();
        Polygon sail2 = new Polygon();
        Polygon sail3 = new Polygon();
        Polygon sail4 = new Polygon();
        sail.getPoints().addAll(x+width/2+width/50,y-height,
                x+width/2+width/50, y-height+height/3*2,
                x+width/3*2,y-height/6*5);
        sail2.getPoints().addAll(x+width/3+width/50,y-height/6*5,
                x+width/3+width/50, y-height+height/3*2,
                x+width/2,y-height/5*3);
        sail3.getPoints().addAll(x+width/3*2+width/50,y-height/6*5,
                x+width/3*2+width/50,y-height+height/3*2,
                x+width/7*6,y-height/6*5);
        sail4.getPoints().addAll(x+width/6+width/50,y-height/3*2,
                x+width/6+width/50, y-height+height/3*2,
                x+width/3,y-height/9*5);
        sail.setFill(new Color(0.9,0.2,0.2,0.9));
        sail2.setFill(new Color(0.9,0.2,0.2,0.9));
        sail3.setFill(new Color(0.9,0.2,0.2,0.9));
        sail4.setFill(new Color(0.9,0.2,0.2,0.9));
        holst.getChildren().addAll(body,mast,mast2,mast3,mast4,sail,sail2,sail3,sail4);
    }
}
