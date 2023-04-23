package mediator;

public class CoolAircon extends Colleague {

    private boolean bOff = true;

    public CoolAircon(Mediator mediator) {
        super(mediator);
    }

    public void on() {
        if (!bOff) return;

        bOff = false;
        System.out.println("# Air condition turned on.");
        mediator.colleagueChanged(this);    // notify to Mediator
    }

    public void off() {
        if (bOff) return;

        bOff = true;
        System.out.println("# Air condition turned off.");
        mediator.colleagueChanged(this);    // notify to Mediator
    }

    public boolean isRunning() {
        return !bOff;
    }

    @Override
    public String toString() {
        if (bOff) return "# Air conditioner: Off";
        else return "# Air conditioner: On";
    }
}
