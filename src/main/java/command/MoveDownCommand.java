package command;

public class MoveDownCommand implements Command {

    private Character character;
    private int distance;

    public MoveDownCommand(Character character, int distance) {
        this.character = character;
        this.distance = distance;
    }

    @Override
    public void execute() {
        character.y += distance;
    }

    @Override
    public void undo() {
        character.y -= distance;
    }
}
