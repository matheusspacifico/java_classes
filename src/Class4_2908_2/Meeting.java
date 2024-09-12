package Class4_2908_2;

import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Meeting(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long durationInMinutes() {
        return Duration.between(startTime, endTime).toMinutes();
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Meeting: " + description + " (" + startTime + " - " + endTime + ")";
    }
}

