package vsu.cg.tasks.engine.base_figures.rectangle;

import javafx.scene.Group;
import vsu.cg.tasks.engine.base_figures.Shape;
import vsu.cg.tasks.services.GlobalConstants;

public class Rectangle extends Shape {
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    protected Rectangle(Group parentScene) {
        super(parentScene);
    }

    public void setPosition(double positionX, double positionY){
        this.positionY = positionY;
        this.positionX = positionX;
    }

    public Rectangle(Group parentScene, int x1, int x2, int y1, int y2) {
        super(parentScene);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        if (x1 > x2) {
            this.x2 = x1;
            this.x1 = x2;
        }
        if (y1 > y2) {
            this.y2 = y1;
            this.y1 = y2;
        }

    }

    @Override
    public void draw() {
        super.draw();
        if (x2 < x1) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        for (int x = x1; x < x2; x++) {
            drawPixel(x, y1);
            drawPixel(x, y2);
        }
        if (y2 < y1) {
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }
        for (int y = y1; y < y2; y++) {
            drawPixel(x1, y);
            drawPixel(x2, y);
        }
    }

    public void translateCoord() {
        x1 -= positionX + GlobalConstants.SCREEN_WIDTH / 2;
        x2 -= positionX + GlobalConstants.SCREEN_WIDTH / 2;
        y1 = (int) (positionY + GlobalConstants.SCREEN_HEIGHT / 2 - y1);
        y2 = (int) (positionY + GlobalConstants.SCREEN_HEIGHT / 2 - y2);

    }

    public Rectangle getIntersection(Rectangle rectangle, Group root) {
        int xL = Math.max(tx1(), rectangle.tx1());
        int xR = Math.min(tx2(), rectangle.tx2());
        if (xR < xL) {
            return null;
        } else {
            int yT = Math.min(ty1(), rectangle.ty1());
            int yB = Math.max(ty2(), rectangle.ty2());
            if (yB >= yT) {
                return null;
            } else {
                Rectangle rectangleNew = new Rectangle(root, (int)(xL -positionX - GlobalConstants.SCREEN_WIDTH/2),
                        (int)(xR -positionX - GlobalConstants.SCREEN_WIDTH/2),
                        (int)(positionY + GlobalConstants.SCREEN_HEIGHT/2- yB),
                        (int)(positionY + GlobalConstants.SCREEN_HEIGHT/2 - yT)
                );

                rectangleNew.setPosition(this.positionX,this.positionY);
                System.out.println(rectangleNew);
                return rectangleNew;
            }
        }
    }

    public int tx1(){
        return  (int)(x1 + positionX + GlobalConstants.SCREEN_WIDTH/2);
    }

    public int tx2(){
        return  (int)(x2 + positionX + GlobalConstants.SCREEN_WIDTH/2);
    }

    public int ty1(){
        System.out.println((int)(positionY + GlobalConstants.SCREEN_HEIGHT/2 - y1));
        return (int)(positionY + GlobalConstants.SCREEN_HEIGHT/2 - y1);
    }

    public int ty2(){
        System.out.println((int)(positionY + GlobalConstants.SCREEN_HEIGHT/2 - y2));
        return (int)(positionY + GlobalConstants.SCREEN_HEIGHT/2 - y2);

    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }


}
