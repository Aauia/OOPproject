package Education;

import java.io.Serializable;
import java.util.Objects;

public class Request implements Serializable{

	private static final long serialVersionUID = 1L;
	private int requestID;
    private StatusInfo status;
    private String requestSender; 
    private RequestType requestType;
    private String additionalAttribute;
    private String  requestSenderCorporateEmail; 

    // Конструктор
    public Request(int requestID, StatusInfo status, String requestSender, RequestType requestType,
                   String additionalAttribute, String requestSenderCorporateEmail) {
        this.requestID = requestID;
        this.status = status;
        this.requestSender = requestSender;
        this.requestType = requestType;
        this.additionalAttribute = additionalAttribute;
        this.requestSenderCorporateEmail = requestSenderCorporateEmail;
    }

    // Геттеры и сеттеры
    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public StatusInfo getStatus() {
        return status;
    }

    public void setStatus(StatusInfo status) {
        this.status = status;
    }

    public String getRequestSender() {
        return requestSender;
    }

    public void setRequestSender(String requestSender) {
        this.requestSender = requestSender;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public String getAdditionalAttribute() {
        return additionalAttribute;
    }

    public void setAdditionalAttribute(String additionalAttribute) {
        this.additionalAttribute = additionalAttribute;
    }

    public String getRequestSenderCorporateEmail() {
        return requestSenderCorporateEmail;
    }

    public void requestSenderCorporateEmail(String requestSenderCorporateEmail) {
        this.requestSenderCorporateEmail = requestSenderCorporateEmail;
    }

    // Переопределение equals и hashCode для корректной работы в коллекциях
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return requestID == request.requestID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestID);
    }

    // toString
    @Override
    public String toString() {
        return "Request{" +
                "requestID=" + requestID +
                ", status=" + status +
                ", requestSender='" + requestSender + '\'' +
                ", requestType=" + requestType +
                ", additionalAttribute='" + additionalAttribute + '\'' +
                ", requestSenderCorporateEmail=" + requestSenderCorporateEmail +
                '}';
    }
}