package mediator;

public class HeatBoiler extends Colleague {

    private boolean bOff = true;

    public HeatBoiler(Mediator mediator) {
        super(mediator);
    }

    public void on() {
        if (!bOff) return;

        bOff = false;
        System.out.println("# Boiler turned on.");
        mediator.colleagueChanged(this);    // notify to Mediator
    }

    public void off() {
        if (bOff) return;

        bOff = true;
        System.out.println("# Boiler turned off.");
        mediator.colleagueChanged(this);    // notify to Mediator
    }

    public boolean isRunning() {
        return !bOff;
    }

    @Override
    public String toString() {
        if (bOff) return "# Heat Boiler: Off";
        else return "# Heat Boiler: On";
    }
}
