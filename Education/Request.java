package Education;

import java.util.List;
import java.util.Objects;

import User.Employee;
import User.Student;

public class Request {
    
	private int requestID;
    private StatusInfo status;
    private String requestSender;
    private RequestType requestType;
    private String additionalAttribute;
    private Employee RequestSender;

    
    // Getters and Setters
    
    public StatusInfo getStatus() {
        return this.status;
    }
    
    public void setStatus(StatusInfo status) {
        this.status = status;
    }
    
    public String getRequestSender() {
        return this.requestSender;
    }
    
    public void setRequestSender(String requestSender) {
        this.requestSender = requestSender;
    }
    
    public RequestType getRequestType() {
        return this.requestType;
    }
    
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }
    
    public String getAdditionalAttribute() {
        return this.additionalAttribute;
    }
    
    public void setAdditionalAttribute(String additionalAttribute) {
        this.additionalAttribute = additionalAttribute;
    }
    
  

    public String getRequestSenderInfo() {
        return this.requestSender;
    }

    public int getRequestID() {
        return this.requestID;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(requestID, request.requestID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestID);
    }
}
