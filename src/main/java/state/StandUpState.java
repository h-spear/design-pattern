package state;

public class StandUpState extends State {

    public StandUpState(Player player) {
        super(player);
    }

    @Override
    public void standUp() {
        player.talk("Are you going to stay still?");
    }

    @Override
    public void sitDown() {
        player.setState(new SitDownState(player));
        player.talk("It's nice to be sitting down.");
    }

    @Override
    public void walk() {
        player.setSpeed(5);
        player.setState(new WalkState(player));
        player.talk("I'll take a walk.");
    }

    @Override
    public void run() {
        player.setSpeed(15);
        player.setState(new RunState(player));
        player.talk("I suddenly want to run.");
    }

    @Override
    public String getDescription() {
        return "standing in place";
    }
}
