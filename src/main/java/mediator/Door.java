package mediator;

public class Door extends Colleague {

    private boolean bClosed = true;

    public Door(Mediator mediator) {
        super(mediator);
    }

    public void open() {
        if (!bClosed) return;

        bClosed = false;
        System.out.println("# Door opened.");
        mediator.colleagueChanged(this);    // notify to Mediator
    }

    public void close() {
        if (bClosed) return;

        bClosed = true;
        System.out.println("# Door closed.");
        mediator.colleagueChanged(this);    // notify to Mediator
    }

    public boolean isClosed() {
        return bClosed;
    }

    @Override
    public String toString() {
        if (bClosed) return "# Door: Closed";
        else return "# Door: Opened";
    }
}
