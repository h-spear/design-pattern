package observer.sport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Soccer extends Sport {

    public Soccer(LocalDateTime sportTime) {
        super(sportTime);
        runningTime = 90;
    }

    @Override
    public String getMessage() {
        return "Soccer game starts at " +
                sportTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                " for " + runningTime + " minutes.";
    }
}
