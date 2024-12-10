package Education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import User.Teacher;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private Teacher teacher;
    private Discipline discipline;
    private String time; // Could be in the format "10:00 AM - 12:00 PM"
    private String day;

    public Schedule(Teacher teacher, Discipline discipline, String time, String day) {
        this.teacher = teacher;
        this.discipline = discipline;
        this.time = time;
        this.day = day;
    }

    
}
