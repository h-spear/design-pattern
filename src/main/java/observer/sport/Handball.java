package observer.sport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Handball extends Sport {

    public Handball(LocalDateTime sportTime) {
        super(sportTime);
        runningTime = 60;
    }

    @Override
    public String getMessage() {
        return "Soccer game starts at " +
                sportTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                " for " + runningTime + " minutes.";
    }
}
