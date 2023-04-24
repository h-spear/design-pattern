package command;

public class MoveRightCommand implements Command {

    private Character character;
    private int distance;

    public MoveRightCommand(Character character, int distance) {
        this.character = character;
        this.distance = distance;
    }

    @Override
    public void execute() {
        character.x += distance;
    }

    @Override
    public void undo() {
        character.x -= distance;
    }
}
