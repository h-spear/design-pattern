package observer;

import observer.sport.Handball;
import observer.sport.Sport;

public class HandballSubscriber extends Subscriber {

    public HandballSubscriber(String name) {
        super(name);
    }

    @Override
    public void notify(Sport sport) {
        if (sport instanceof Handball) {
            this.notifyCount++;
            System.out.println("notify! " + name + ": " + sport.getMessage());
        }
    }
}
