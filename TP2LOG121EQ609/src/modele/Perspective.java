package modele;

import java.awt.*;

public class Perspective {
private Image imageSource;
private Point posCourrant;
private double scale = 1.0; //initial

    public Point getPosCourrant() {
        return posCourrant;
    }

    public double getScale() {
        return scale;
    }

    public void setPosCourrant(Point posCourrant) {
        this.posCourrant = posCourrant;
    }
}
