package state;

public class Player {
    private String name;
    private int speed;
    private State state;
    private int stateChangeCount = 0;

    public Player(String name) {
        this.name = name;
        state = new StandUpState(this);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        stateChangeCount++;
    }

    public int getStateChangeCount() {
        return stateChangeCount;
    }

    public void talk(String msg) {
        System.out.println(name + ": \"" + msg + "\"");
    }
}
