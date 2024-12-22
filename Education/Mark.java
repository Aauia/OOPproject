package Education;

import java.util.Objects;

import User.Student;

public class Mark {      
    private double firstAttestation; 
    private double secondAttestation;
    private double finalMark;  
    private String status;

    public Mark( double firstAttestation, double secondAttestation, double finalMark) {
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalMark = finalMark;
        this.status = determineStatus(finalMark); 
    }
    
    
    private String determineStatus(double finalMark) {
        return finalMark >= 50 ? "Passed" : "Failed";
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



    public int getSum() {
        return (int) (firstAttestation + secondAttestation + finalMark);
    }

    public void updateMark(double newFinalMark) {
        this.finalMark = newFinalMark;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}