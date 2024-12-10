package Education;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Transcript implements Serializable {
    // Map semester -> (Discipline -> GradeDetails)
    private Map<String, Map<Discipline, Mark>> semesterRecords;

    public Transcript() {
        this.semesterRecords = new HashMap<>();
    }

    // Add a record for a specific semester
    public void addRecord(String semester, Discipline discipline, int attestation1, int attestation2, int finalExam) {
        semesterRecords.putIfAbsent(semester, new HashMap<>());
        GradeDetails grades = new GradeDetails(attestation1, attestation2, finalExam);
        semesterRecords.get(semester).put(discipline, grades);
    }

    // Get records for a specific semester
    public Map<Discipline, GradeDetails> getRecordsForSemester(String semester) {
        return semesterRecords.getOrDefault(semester, new HashMap<>());
    }

    // Get all semester records
    public Map<String, Map<Discipline, GradeDetails>> getAllRecords() {
        return semesterRecords;
    }

    // Display transcript
    public void displayTranscript() {
        for (Map.Entry<String, Map<Discipline, GradeDetails>> semesterEntry : semesterRecords.entrySet()) {
            System.out.println("Semester: " + semesterEntry.getKey());
            for (Map.Entry<Discipline, GradeDetails> record : semesterEntry.getValue().entrySet()) {
                System.out.println("- Discipline: " + record.getKey().getName());
                System.out.println("  " + record.getValue());
            }
        }
    }
}
