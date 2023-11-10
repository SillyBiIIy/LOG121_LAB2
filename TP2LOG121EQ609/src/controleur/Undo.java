package controleur;

import Command.Command;
import modele.Perspective;

public class Undo implements Command {

    public void undoCommand(Perspective image){
        //TODO - set var du modele au plus recent memento
        //set modele
        //listCommands.pop -> get memento
        //image.setPosCourrant();
        //image.setScale();
    }


    @Override
    public void performCommand(Perspective image) {
        undoCommand(image);
    }
}
