package vsu.cg.tasks.engine.baseFigures.arch;

import javafx.scene.Group;
import vsu.cg.tasks.engine.baseFigures.Shape;

public class Arch extends Shape {
    protected double x1;
    protected double y1;
    protected double l;
    protected double h;

    public Arch(Group parentGroup, double x1, double y1, double l, double h) {
        super(parentGroup);
        this.x1 = x1;
        this.y1 = y1;
        this.l = l;
        this.h = h;
    }

    public Arch(Group parentGroup) {
        this(parentGroup, 0, 0, 0, 0);
    }

    @Override
    public void draw() {

    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
