package observer.sport;

import java.time.LocalDateTime;

public abstract class Sport {

    protected LocalDateTime sportTime;
    protected int runningTime;

    public Sport(LocalDateTime sportTime) {
        this.sportTime = sportTime;
    }

    public abstract String getMessage();
}
