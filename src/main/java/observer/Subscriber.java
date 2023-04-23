package observer;

import observer.sport.Sport;

public abstract class Subscriber {

    protected String name;
    protected int notifyCount;    // 테스트용

    public Subscriber(String name) {
        this.name = name;
        this.notifyCount = 0;
    }

    public int getNotifyCount() {
        return notifyCount;
    }

    public abstract void notify(Sport sport);
}
