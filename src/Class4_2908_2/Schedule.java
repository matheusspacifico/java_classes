package Class4_2908_2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private final LocalDate day;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final Meeting[] meetings;
    private int meetingCount;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetings = new Meeting[10];
        this.meetingCount = 0;
    }

    public void addMeeting(Meeting meeting) {
        if (meeting.getStartTime().isBefore(startTime) || meeting.getEndTime().isAfter(endTime)) {
            System.out.println("Meeting cannot be scheduled outside of working hours!");
            return;
        }

        for (int i = 0; i < meetingCount; i++) {
            Meeting existingMeeting = meetings[i];
            if (meeting.getEndTime().isAfter(existingMeeting.getStartTime()) && meeting.getStartTime().isBefore(existingMeeting.getEndTime())) {
                System.out.println("Meetings cannot overlap!");
                return;
            }
        }


        if (meetingCount < meetings.length) {
            meetings[meetingCount] = meeting;
            meetingCount++;
            System.out.println("Meeting was successfully scheduled!");
        } else {
            System.out.println("Maximum number of meetings reached.");
        }
    }

    public void removeMeeting(Meeting meeting) {
        if (meetingCount == 0) {
            System.out.println("No meetings scheduled!");
            return;
        }

        for (int i = 0; i < meetingCount; i++) {
            if (meetings[i] == meeting) {

                for (int j = i; j < meetingCount - 1; j++) {
                    meetings[j] = meetings[j + 1];
                }
                meetings[meetingCount - 1] = null;
                meetingCount--;
                System.out.println("Meeting was successfully removed!");
                return;
            }
        }

        System.out.println("You must schedule the meeting first before removing it!");
    }

    public double percentageSpentInMeetings() {
        long totalMinutes = Duration.between(startTime, endTime).toMinutes();
        long meetingMinutes = 0;

        for (int i = 0; i < meetingCount; i++) {
            meetingMinutes += meetings[i].durationInMinutes();
        }

        return (double) meetingMinutes / totalMinutes * 100;
    }

    public String scheduleAsString() {
        StringBuilder output = new StringBuilder();

        output.append("Schedule for ").append(day).append(":\n");
        output.append("Working hours: ").append(startTime).append(" - ").append(endTime).append("\n");

        if (meetingCount == 0) {
            output.append("No meetings scheduled.\n");
        } else {
            for (int i = 0; i < meetingCount; i++) {
                output.append(meetings[i].toString());
                output.append("\n");
            }
        }

        return output.toString();
    }
}

