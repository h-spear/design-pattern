package command;

public class MoveUpCommand implements Command {

    private Character character;
    private int distance;

    public MoveUpCommand(Character character, int distance) {
        this.character = character;
        this.distance = distance;
    }

    @Override
    public void execute() {
        character.y -= distance;
    }

    @Override
    public void undo() {
        character.y += distance;
    }
}
