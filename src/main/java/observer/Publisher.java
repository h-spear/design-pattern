package observer;

import observer.sport.Sport;

import java.util.LinkedList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers = new LinkedList<>();

    public Publisher() {
    }

    public boolean addSubscriber(Subscriber subscriber) {
        return subscribers.add(subscriber);
    }

    public boolean removeSubscriber(Subscriber subscriber) {
        return subscribers.remove(subscriber);
    }

    public void scheduleGame(Sport sport) {
        System.out.println("A new sport game has been scheduled.");
        for (Subscriber subscriber: subscribers) {
            subscriber.notify(sport);
        }
        System.out.println();
    }
}
