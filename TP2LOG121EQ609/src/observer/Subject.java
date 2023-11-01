package observer;

import java.util.LinkedList;
import java.util.List;

public abstract class Subject {
    /**Code copié d'un code fourni dans le labo 5 et 6 dans le Cours GTI100 ÉTÉ 2023**/
    private List<Observer> listObservers = new LinkedList<Observer>();

    public void attach(Observer o) {
        listObservers.add(o);
    }

    public void detach(Observer o) {
        listObservers.remove(o);
    }

    public void notifyObservers() {
        for (Observer obv : listObservers) {
            obv.update();
        }
    }
     /** Fin du code copié **/
}
