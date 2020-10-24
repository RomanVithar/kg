package vsu.cg.tasks.engine.assets.backgrounds;

import vsu.cg.tasks.engine.baseFigures.Shape;
import vsu.cg.tasks.engine.assets.simple_objects.Sky;
import vsu.cg.tasks.engine.assets.simple_objects.Water;

public class SeaBack extends Shape {
    
    public SeaBack(int x, int y, double width, double height) {
        Sky sky = new Sky(x,y,width,height);
        sky.putOnGroup(holst);
        Water water = new Water(x,height/9*5,width,height/9*4);
        water.putOnGroup(holst);
    }
}