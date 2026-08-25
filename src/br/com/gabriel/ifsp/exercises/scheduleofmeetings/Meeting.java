package br.com.gabriel.ifsp.exercises.scheduleofmeetings;

import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private String description;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Meeting(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public long durationInMinutes() {
        return Duration.between(startTime, endTime).toMinutes();
    }
}
