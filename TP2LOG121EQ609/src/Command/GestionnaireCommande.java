package Command;

import java.util.LinkedList;
import java.util.Stack;

import Memento.*;
import modele.Perspective;

public class GestionnaireCommande {

//****** Variables **********
    private static GestionnaireCommande instance;

    private GestionnaireCommande(){}


    private ListCommands list = ListCommands.getInstance();
    private Command command;

//****** Methodes **********

    /**
     * obtient l'instance singleton du gestionnaire de commande
     * @return instance
     */
    public static GestionnaireCommande getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommande();
        }
        return instance;
    }

    /**
     * Set quelle commande nous allons utiliser
     * @param command
     */
    public void setCommand(Command command){
        this.command=command;
    }

    /**
     * Effectue la commande choisit
     */
    public void execute(Perspective image){
        saveState(image);
        command.performCommand(image);
    }

    /**
     *
     */
    private void saveState(Perspective image){
        MementoImage capture = new MementoImage(image);
        list.add(capture);
    }


}
