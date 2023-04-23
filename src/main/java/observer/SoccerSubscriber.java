package observer;

import observer.sport.Soccer;
import observer.sport.Sport;

public class SoccerSubscriber extends Subscriber {

    public SoccerSubscriber(String name) {
        super(name);
    }

    @Override
    public void notify(Sport sport) {
        if (sport instanceof Soccer) {
            this.notifyCount++;
            System.out.println("notify! " + name + ": " + sport.getMessage());
        }
    }
}
