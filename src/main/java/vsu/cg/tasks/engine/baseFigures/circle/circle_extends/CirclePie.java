package vsu.cg.tasks.engine.baseFigures.circle.circle_extends;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import vsu.cg.tasks.engine.baseFigures.circle.Circle;

import java.util.*;

public class CirclePie extends Circle {
    private List<Integer> listPie;
    private List<Double> listAngle;
    private Deque<Color> palette;

    public CirclePie(Group parentGroup, double x1, double y1, double r) {
        super(parentGroup, x1, y1, r);
        fillPalette();
    }

    @Override
    public void draw() {
        fillListAngle();
        Iterator<Double> iterator = listAngle.iterator();
        Double angle = iterator.next();
        setColor(getNextColor());
        for (double dAngle = Math.PI / 2; dAngle < 2.5 * Math.PI; dAngle += Math.PI / 180) {
            if (dAngle > angle + Math.PI / 2) {
                if (iterator.hasNext()) {
                    angle = iterator.next();
                } else {
                    iterator = listAngle.iterator();
                    angle = iterator.next() + 2 * Math.PI;
                }
                setColor(getNextColor());
            }
            for (double dr = 0; dr <= r; dr += PX_SIZE) {
                for (int i = -2; i < 2; i++) {
                    for (int j = -2; j < 2; j++) {
                        drawPixel(x1 + Math.cos(dAngle) * dr + i, y1 - Math.sin(dAngle) * dr + j);
                    }
                }
            }
        }
    }

    private void fillPalette() {
        palette = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            palette.add(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
        }
        palette.add(Color.GREY);
        palette.add(Color.OLDLACE);
        palette.add(Color.GREEN);
        palette.add(Color.FUCHSIA);
        palette.add(Color.RED);
        palette.add(Color.LAWNGREEN);
        palette.add(Color.BLUE);
        palette.add(Color.ORANGE);
    }

    private Color getNextColor() {
        palette.addFirst(palette.pollLast());
        return palette.peekFirst();
    }

    private void fillListAngle() {
        double sumPieKoef = 0;
        for (Integer pie : listPie) {
            sumPieKoef += pie;
        }
        listAngle = new ArrayList<>();
        double angleBefore = 0;
        for (Integer pie : listPie) {
            listAngle.add(angleBefore + (pie / sumPieKoef) * 2 * Math.PI);
            angleBefore += (pie / sumPieKoef) * 2 * Math.PI;
        }
    }

    public void setListPie(List<Integer> listPie) {
        this.listPie = listPie;
    }
}
