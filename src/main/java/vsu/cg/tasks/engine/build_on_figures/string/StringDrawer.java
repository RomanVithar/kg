package vsu.cg.tasks.engine.build_on_figures.string;

import javafx.scene.Group;
import vsu.cg.tasks.engine.base_figures.Draw;
import vsu.cg.tasks.engine.base_figures.Shape;

import java.util.List;

public class StringDrawer implements Draw {
    private Group parentGroup;
    private List<Shape> shapeList;
    private String string;
    private double x0;
    private double y0;

    public StringDrawer(Group parentGroup, List<Shape> shapeList, String string, double x0, double y0) {
        this.parentGroup = parentGroup;
        this.shapeList = shapeList;
        this.string = string;
        this.x0 = x0;
        this.y0 = y0;
    }

    @Override
    public void draw() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }
}
