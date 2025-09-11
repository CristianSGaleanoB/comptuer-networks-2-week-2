package src.Activity1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class Errors {
    @XmlElement
    public String actualDate;

    @XmlElement
    public String message;

    @XmlElement
    public Priority priority;

    public Errors() {}

    public Errors(String actualDate, String message, Priority priority) {
        this.actualDate = actualDate;
        this.message = message;
        this.priority = priority;
    }

    public String getActualDate() { return actualDate;}
    public String getMessage() { return message; }
    public Priority getPriority() { return priority; }

    public void setActualDate(String actualDate) { this.actualDate = actualDate; }
    public void setMessage(String message) { this.message = message; }
    public void setPriority(Priority priority) { this.priority = priority; }
}
