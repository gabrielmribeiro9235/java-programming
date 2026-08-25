package br.com.gabriel.ifsp.exercises.scheduleofmeetings;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule(LocalDate.now(), LocalTime.of(6, 0, 0), LocalTime.of(18, 0, 0));
        Meeting meeting = new Meeting("Daily to review", LocalTime.of(8, 25), LocalTime.of(12, 0));

        System.out.println("Initial description: " + meeting.getDescription());

        meeting.setDescription("Sprint review");

        System.out.println("Actual description: " + meeting.getDescription());

        System.out.println("\nDuration of the first meeting in minutes: " + meeting.durationInMinutes());

        schedule.addMeeting(meeting);
        schedule.addMeeting(new Meeting("Second meeting", LocalTime.of(12, 30), LocalTime.of(14, 0)));
        schedule.addMeeting(new Meeting("Third meeting", LocalTime.of(16, 30), LocalTime.of(17, 0)));

        System.out.println("\nSchedule:");
        System.out.println(schedule.scheduleAsString());

        schedule.removeMeeting(meeting);

        System.out.println("\nNew Schedule:");
        System.out.println(schedule.scheduleAsString());

        System.out.printf("Percentual of time spent in meetings: %.2f %%", schedule.percentageSpentInMeetings());
    }
}
