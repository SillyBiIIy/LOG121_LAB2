package controleur;

import Command.*;

public class ZoomController implements Command {
    private Zoom zoomDirection;

    public ZoomController(Zoom zoomDir){
        this.zoomDirection=zoomDir;
    }

    @Override
    public void performCommand(){
        zoom();
    }

    public void zoom(){
        //zoomDirection;
    }

}
