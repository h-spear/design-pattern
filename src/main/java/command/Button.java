package command;

import java.util.Stack;

/**
 * Invoker
 */
public class Button {

    private Stack<Command> commandHistory = new Stack<>();
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        commandHistory.push(command);
    }

    public void pressUndoButton() {
        if (!commandHistory.isEmpty()) {
            commandHistory.pop().undo();
        }
    }
}
