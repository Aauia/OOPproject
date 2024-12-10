package Education;

import java.io.Serializable;
import java.time.LocalTime;

public class ScheduleEntry implements Serializable {
    private Discipline discipline;
    private String teacher;
    private String room;
    private String day; // e.g., "Monday", "Tuesday"
    private LocalTime startTime;
    private LocalTime endTime;

    // Constructor
    public ScheduleEntry(Discipline discipline, String teacher, String room, String day, LocalTime startTime, LocalTime endTime) {
        this.discipline = discipline;
        this.teacher = teacher;
        this.room = room;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Discipline: " + discipline.getName() +
               ", Teacher: " + teacher +
               ", Room: " + room +
               ", Day: " + day +
               ", Time: " + startTime + " - " + endTime;
    }
}
