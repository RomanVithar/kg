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

    public Rectangle(Group parentScene, int x1, int x2, int y1, int y2) {
        super(parentScene);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void draw() {
        super.draw();
        if(x2<x1){
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        for(int x = x1;x<x2;x++){
            drawPixel(x,y1);
            drawPixel(x,y2);
        }
        if(y2<y1){
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }
        for(int y = y1;y<y2;y++){
            drawPixel(x1,y);
            drawPixel(x2,y);
        }
    }

    public void translateCoord() {
        x1 -= positionX + GlobalConstants.SCREEN_WIDTH/2;
        x2 -= positionX + GlobalConstants.SCREEN_WIDTH/2;
        y1 = (int)(positionY + GlobalConstants.SCREEN_HEIGHT/2 - y1);
        y2 = (int)(positionY + GlobalConstants.SCREEN_HEIGHT/2 - y2);

    }

    public Rectangle getIntersection(Rectangle rectangle) {
        int xL = Math.max(x1, rectangle.x1);
        int xR = Math.min(x2,rectangle.x2);
        if(xR<xL){
            return null;
        }else{
            int yT = Math.max(y1, rectangle.y1);
            int yB = Math.min(y2, rectangle.y2);
            if (yB <= yT)
                return null;
            else
                return new Rectangle(parentGroup, xL, xR, yB, yT);
        }
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
