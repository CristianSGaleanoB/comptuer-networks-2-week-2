package Activity1;

import java.util.Date;

public class Errors {
    public Date actualDate;
    public String message;
    public Priority priority;
    public Errors(Date actualDate, String message, Priority priority) {
        this.actualDate = actualDate;
        this.message = message;
        this.priority = priority;
    }
}
