package vsu.cg.tasks.engine.base_figures.kurve;

import javafx.scene.Group;
import vsu.cg.tasks.engine.base_figures.Shape;

import java.awt.*;
import java.util.ArrayList;


public class KurveBezier extends Shape {
    private ArrayList<Point> points;

    private ArrayList<Integer> basisFunctions;

    public KurveBezier(Group parentScene) {
        super(parentScene);
        points = new ArrayList<Point>();
        basisFunctions = new ArrayList<>();
    }


    @Override
    public void draw() {
        super.draw();
        double x = 0;
        double y = 0;
        fillBasisFunctions();
        int n = points.size()-1;
        for (double t = 0; t <= 1; t += 0.001) {
            x = 0;
            y = 0;
            for (int k = 0; k < points.size(); k++) {
                x += funcBezier(n, k, t) * points.get(k).x;
                y += funcBezier(n, k, t) * points.get(k).y;
            }
            drawPixel(x, y);
        }
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    private int factorial(int a) {
        int result = 1;
        int number = a;
        for (int i = 0; i < a; i++) {
            result *= number;
            number--;
        }
        return result;
    }

    private double funcBezier(int n, int k, double t) {
        double result = basisFunctions.get(k);
        result *= Math.pow(t, k);
        result *= Math.pow(1 - t, n - k);
        return result;
    }

    private void fillBasisFunctions() {
        int n = points.size()-1;
        for (int k = 0; k < points.size(); k++) {
            basisFunctions.add(factorial(n) / (factorial(k) * factorial(n - k)));
        }
    }
}
