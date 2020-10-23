package vsu.cg.tasks;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import vsu.cg.tasks.engine.baseFigures.Line;
import vsu.cg.tasks.task1.Task1;

public class Run {

    //    public static void main(String[] args) {
//        Application.launch(args);
//    }
//
//    public void start(Stage primaryStage) throws Exception {
//        Button btn = new Button("task 1");
//        btn.setPrefWidth(100);
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Task1 task = new Task1();
//                task.run();
//            }
//        });
//        FlowPane root = new FlowPane(btn);
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Start tasks");
//        primaryStage.setWidth(450);
//        primaryStage.setHeight(300);
//        primaryStage.show();
//    }
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}







//package vsu.cg.tasks.engine.baseFigures;
//
//        import javafx.scene.paint.Color;
//
//public class LineBresenham extends Line {
//
//    public LineBresenham(double x1, double y1, double x2, double y2) {
//        super(x1, y1, x2, y2);
//    }
//
//    @Override
//    public void drawLine() {
//        int deltax, deltay, error, deltaerr, y, x, diry, dirx;
//        deltax = (int) Math.abs(x2 - x1);
//        deltay = (int) Math.abs(y2 - y1);
//        error = 0;
//        if(x2 <x1){
//            double mem = x2;
//            x2 = x1;
//            x1 = mem;
//            mem = y2;
//            y2 = y1;
//            y1 = mem;
//        }
//        if (deltax > deltay) {
//            deltaerr = deltay + 1;
//            y = (int) y1;
//            diry = (int) (y2 - y1);
//            if (diry > 0) {
//                diry = PXSIZE;
//            }
//            if (diry < 0) {
//                diry = -PXSIZE;
//            }
//            for (double x0 = x1; x0 < x2; x0+=PXSIZE) {
//                drawPixel(x0, y);
//                error = error + deltaerr;
//                if (error >= (deltax + 1)) {
//                    y += diry;
//                    error -= (deltax + 1);
//                }
//            }
//        } else {
//            deltaerr = deltax + 1;
//            x = (int) x1;
//            dirx = (int) (x2 - x1);
//            if (dirx > 0) {
//                dirx = PXSIZE;
//            }
//            if (dirx < 0) {
//                dirx = -PXSIZE;
//            }
//            if(y2<y1){
//                for (double y0 = y1; y0 > y2; y0-=PXSIZE) {
//                    drawPixel(x, y0);
//                    error = error + deltaerr;
//                    if (error >= (deltay + 1)) {
//                        x += dirx;
//                        error -= (deltay + 1);
//                    }
//                }
//            }else {
//                for (double y0 = y1; y0 < y2; y0+=PXSIZE) {
//                    drawPixel(x, y0);
//                    error = error + deltaerr;
//                    if (error >= (deltay + 1)) {
//                        x += dirx;
//                        error -= (deltay + 1);
//                    }
//                }
//            }
//        }
//    }
//}



