package controleur;

import Command.Command;
import modele.Perspective;

import java.awt.*;

public class Translation implements Command {

    private Point last = new Point(0,0);
    private Point current = new Point();
    private Point delta = new Point();
    private Point mousePos = new Point();

    public void setMousePos(Point mousePos) {
        this.mousePos = mousePos;
    }

    public Point translationCommand(Point mousePos){

        delta.x = mousePos.x - last.x;
        delta.y = mousePos.y - last.y;

        System.out.println("Mouse Dragged: " + mousePos.x + ":" + mousePos.getY());
        System.out.println("Last: " + last.x + ":" + last.y);
        System.out.println("dX - dY: " + delta.x + ":" + delta.y);
        System.out.println("Offset: " + current.x + ":" + current.y);
        System.out.println("-------------------------------------");

        current.translate(delta.x, delta.y);
        last.setLocation(current);

        return current;
    }

    @Override
    public void performCommand(Perspective image) {
        image.setPosCourrant(translationCommand(mousePos));
    }


    public static Point dragged(Point mousePos){
        Point last = new Point();
        Point picPos = new Point();
//        int dx = -500;
//        int dy = -500;
        int dx = mousePos.x - last.x;
        int dy = mousePos.y - last.y;

        picPos.x = last.x + dx;
        picPos.y = last.y + dy;
//        xOffset = lastX+dx;
//        yOffset = lastY+dy;

        last.x = picPos.x;
        last.y = picPos.y;
//        lastX = e.getX();
//        lastY = e.getY();

//        xOffset = lastX+dx;
//        yOffset = lastY+dy;

        System.out.println("Mouse Dragged: " + mousePos.x + ":" + mousePos.getY());
        System.out.println("Last: " + last.x + ":" + last.y);
        System.out.println("dX - dY: " + dx + ":" + dy);
        System.out.println("Offset: " + picPos.x + ":" + picPos.y);
        System.out.println("-------------------------------------");
        return picPos;
    }


}
