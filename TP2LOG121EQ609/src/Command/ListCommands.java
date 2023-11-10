package Command;

import java.util.Stack;
import Memento.*;

public class ListCommands {

    private Stack<MementoImage> Commands = new Stack<MementoImage>();
    private static ListCommands instance;

    private ListCommands(){}

    public static ListCommands getInstance() {
        if (instance == null) {
            instance = new ListCommands();
        }
        return instance;
    }

    public void add(MementoImage instance){
        Commands.push(instance);
    }

    public MementoImage remove(){
        return Commands.pop();
    }

//    public MementoImage peek(){
//        return Commands.peek();
//    }

}
