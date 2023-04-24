package state;

public class WalkState extends State {
    public WalkState(Player player) {
        super(player);
    }

    @Override
    public void standUp() {
        player.setSpeed(0);
        player.talk("stop...");
        player.setState(new StandUpState(player));
    }

    @Override
    public void sitDown() {
        player.setSpeed(0);
        player.talk("It's dangerous if suddenly sit down while walking.");
        player.setState(new SitDownState(player));
    }

    @Override
    public void walk() {
        player.talk("I like walking.");
    }

    @Override
    public void run() {
        player.setSpeed(20);
        player.talk("Let's Run!");
        player.setState(new RunState(player));
    }

    @Override
    public String getDescription() {
        return "walking";
    }
}
