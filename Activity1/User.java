package Activity1;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    public String email;
    public int id;
    public String ipAddress;
    public String deviceName;
    public String operativeSystem;
    public boolean startConnection;
    public boolean endConnection;
    public List<Errors> errors;

    public User(String name, String email, int id, String ipAddress, String deviceName, String operativeSystem, boolean startConnection, boolean endConnection) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.ipAddress = ipAddress;
        this.deviceName = deviceName;
        this.operativeSystem = operativeSystem;
        this.startConnection = false;
        this.endConnection = false;
        this.errors = new ArrayList<Errors>();
    }
}
