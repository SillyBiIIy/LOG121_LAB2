package Memento;

import modele.Perspective;

import java.awt.*;

public class MementoImage {

//****** Variables **********
    private Point posCourrant;
    private double zoom;


//****** Methodes **********

    /**
     * constructeur du memento
     * @param posCourrant
     * @param zoom
     */
    public MementoImage(Point posCourrant, double zoom) {
        this.posCourrant = posCourrant;
        this.zoom = zoom;
    }
    public MementoImage(Perspective image) {
        this.posCourrant = image.getPosCourrant();
        this.zoom = image.getScale();
    }

    public Point getPosCourrant() {
        return posCourrant;
    }

    public double getZoom() {
        return zoom;
    }

}
