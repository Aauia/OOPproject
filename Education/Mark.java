package Education;

import java.io.Serializable;
import java.util.Objects;

import User.Student;

public class Mark implements Serializable {      
    private double firstAttestation; 
    private double secondAttestation;
    private double finalMark;  
    private String status;

    public Mark( double firstAttestation, double secondAttestation, double finalMark) {
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalMark = finalMark;
        this.status = determineStatus(firstAttestation,secondAttestation,finalMark); 
    }
    private String determineStatus(double firstAttestation, double secondAttestation, double finalMark) {
        double totalMarks = firstAttestation + secondAttestation + finalMark;

        // If total marks are below 50, return "Failed"
        if (totalMarks < 50) {
            return "Failed";
        }

        // Determine grade based on the total marks
        if (totalMarks >= 90) {
            return "A";
        } else if (totalMarks >= 80) {
            return "B+";
        } else if (totalMarks >= 70) {
            return "B";
        } else if (totalMarks >= 60) {
            return "C+";
        } else if (totalMarks >= 50) {
            return "C-";
        }

        return "Failed"; // Default, though this shouldn't happen due to earlier condition
    }

    
    
 

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public double getFinalMark() {
        return finalMark;
    }



    public double getSum() {
        return (double ) (firstAttestation + secondAttestation + finalMark);
    }

    public void updateMark(double newFinalMark) {
        this.finalMark = newFinalMark;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(double firstAttestation, double secondAttestation, double finalMark) {
		this.status = determineStatus(firstAttestation,secondAttestation,finalMark);
	}
    public boolean isAssigned() {
        return firstAttestation != 0 || secondAttestation != 0 || finalMark != 0;
    }

	public String getValue() {
	    return "First Attestation: " + firstAttestation +
	           ", Second Attestation: " + secondAttestation +
	           ", Final Mark: " + finalMark +
	           ", Status: " + status;
	}


	public void setFirstAttestation(double firstAttestation2) {
		this.firstAttestation = firstAttestation2;
		
	}
	public void setSecondAttestation(double secondAttestation2) {
		this.secondAttestation = secondAttestation2;
		
	}
	public void setFinalMark(double Final) {
		this.finalMark = Final;
		
	}

}
