package br.com.gabriel.ifsp.exercises.scheduleofmeetings;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private final LocalDate day;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private Meeting[] meetings = new Meeting[50];
    private int numberOfMeetings = 0;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private void increaseArraySize() {
        Meeting[] copy = meetings.clone();

        meetings = new Meeting[meetings.length + 50];

        for (int i = 0; i < copy.length; i++) {
            meetings[i] = copy[i];
        }
    }

    public void addMeeting(Meeting meeting) {
        if (meeting.getStartTime().isBefore(startTime) || meeting.getEndTime().isAfter(endTime)) return;

        for (int i = 0; i < numberOfMeetings; i++) {
            if (
                (meetings[i].getStartTime().isBefore(meeting.getStartTime()) && meetings[i].getEndTime().isAfter(meeting.getStartTime())) ||
                (meetings[i].getStartTime().isBefore(meeting.getEndTime()) && meetings[i].getEndTime().isAfter(meeting.getEndTime())) ||
                (meetings[i].getStartTime().isAfter(meeting.getStartTime()) && meetings[i].getEndTime().isBefore(meeting.getEndTime())) ||
                meetings[i].getStartTime().equals(meeting.getStartTime()) ||
                meetings[i].getEndTime().equals(meeting.getEndTime())
            ) {
                return;
            }
        }
        if (numberOfMeetings % 50 == 0) {
            increaseArraySize();
        }

        meetings[numberOfMeetings++] = meeting;
    }

    public void removeMeeting(Meeting meeting) {
        if (numberOfMeetings == 0) return;

        int indexToRemove = -1;

        for (int i = 0; i < numberOfMeetings; i++) {
            if (
                meeting.getEndTime().equals(meetings[i].getEndTime()) &&
                meeting.getStartTime().equals(meetings[i].getStartTime())
            ) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) return;

        for (int i = indexToRemove; i < numberOfMeetings - 1; i++) {
            meetings[i] = meetings[i+1];
        }

        numberOfMeetings--;
    }

    public double percentageSpentInMeetings() {
        long totalInMinutes = Duration.between(startTime, endTime).toMinutes();

        long spentInMeetings = 0;
        for (int i = 0; i < numberOfMeetings; i++) {
            spentInMeetings += meetings[i].durationInMinutes();
        }

        return ((double) spentInMeetings / totalInMinutes) * 100;
    }

    public String scheduleAsString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(
            "[day: %s, start time: %s, end time: %s", day.toString(), startTime.toString(), endTime.toString()
        ));

        for (int i = 0; i < numberOfMeetings; i++) {
            result.append(String.format(
                ", Meeting %d: [description: %s, start time: %s, end time: %s]", i + 1, meetings[i].getDescription(), meetings[i].getStartTime(), meetings[i].getEndTime()
            ));
        }

        result.append("]");

        return result.toString();
    }
}
