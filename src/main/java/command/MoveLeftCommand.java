package command;

public class MoveLeftCommand implements Command {

    private Character character;
    private int distance;

    public MoveLeftCommand(Character character, int distance) {
        this.character = character;
        this.distance = distance;
    }

    @Override
    public void execute() {
        character.x -= distance;
    }

    @Override
    public void undo() {
        character.x += distance;
    }
}
