package state;

public class SitDownState extends State {

    public SitDownState(Player player) {
        super(player);
    }

    @Override
    public void standUp() {
        player.setState(new StandUpState(player));
        player.talk("Stand up!");
    }

    @Override
    public void sitDown() {
        player.talk("I'm already sitting down.");
    }

    @Override
    public void walk() {
        player.talk("I can't walk while sitting. I'll stand up first.");
        player.setState(new StandUpState(player));
    }

    @Override
    public void run() {
        player.talk("I can't run while sitting. I'll stand up first.");
        player.setState(new StandUpState(player));
    }

    @Override
    public String getDescription() {
        return "sitting down";
    }
}
