package command;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CommandGroup implements Command {

    private List<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command: commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        ListIterator<Command> it = commands.listIterator(commands.size());
        while (it.hasPrevious()) {
            it.next().undo();
        }
    }
}
