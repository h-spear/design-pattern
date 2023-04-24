package state;

public class RunState extends State {
    public RunState(Player player) {
        super(player);
    }

    @Override
    public void standUp() {
        player.talk("It's dangerous to stop suddenly while running.");
        player.setSpeed(0);
        player.setState(new StandUpState(player));
    }

    @Override
    public void sitDown() {
        player.talk("I can't sit down while running. I'll stand up first.");
        player.setSpeed(0);
        player.setState(new StandUpState(player));
    }

    @Override
    public void walk() {
        player.talk("I'll go a little slower.");
        player.setSpeed(8);
        player.setState(new WalkState(player));
    }

    @Override
    public void run() {
        player.talk("Faster!!!");
        player.setSpeed(player.getSpeed() + 2);
    }

    @Override
    public String getDescription() {
        return "running";
    }
}
