package mediator;

public class Window extends Colleague {

    private boolean bClosed = true;

    public Window(Mediator mediator) {
        super(mediator);
    }

    public void open() {
        if (!bClosed) return;

        bClosed = false;
        System.out.println("# Window opened.");
        mediator.colleagueChanged(this);    // notify to Mediator
    }

    public void close() {
        if (bClosed) return;

        bClosed = true;
        System.out.println("# Window closed.");
        mediator.colleagueChanged(this);    // notify to Mediator
    }

    public boolean isClosed() {
        return bClosed;
    }

    @Override
    public String toString() {
        if (bClosed) return "# Window: Closed";
        else return "# Window: Opened";
    }
}
