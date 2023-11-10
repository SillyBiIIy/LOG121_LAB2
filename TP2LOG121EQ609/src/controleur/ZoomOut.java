package controleur;

import Command.Command;
import modele.Perspective;

import java.awt.*;

public class ZoomOut implements Command {

    private double scale;
    private final double ZOOM_FACTOR = 1.1; // Adjust this value for zoom sensitivity
    private int notches;

    public void setNotches(int notches) {
        this.notches = notches;
    }

    private void zoomCommand(){

            scale /= ZOOM_FACTOR;
            //set scale of image

    }
    @Override
    public void performCommand(Perspective image) {
        zoomCommand();
    }


}
