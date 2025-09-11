package src.Activity1;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlElement
    private String name;
    @XmlElement
    private String email;
    @XmlElement
    private int id;

    @XmlElement(name = "ipAddress")
    private String ipAddress;

    @XmlElement(name = "deviceName")
    private String deviceName;

    @XmlElement
    private String os;

    @XmlElement(name = "startConnection")
    private String startConnection;

    @XmlElement(name = "endConnection")
    private String endConnection;

    @XmlElementWrapper(name = "errors")
    @XmlElement(name = "error")
    private List<Errors> errors;

    public User(){}

    public User(String name, String email, int id, String ipAddress, String deviceName, String os,
                String startConnection, String endConnection, List<Errors> errors) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.ipAddress = ipAddress;
        this.deviceName = deviceName;
        this.os = os;
        this.startConnection = startConnection;
        this.endConnection = endConnection;
        this.errors = errors;
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
    public int getId() {return id;}
    public String getIpAddress() {return ipAddress;}
    public String getDeviceName() {return deviceName;}
    public String getOs() {return os;}
    public String getStartConnection() {return startConnection;}
    public String getEndConnection() {return endConnection;}
    public List<Errors> getErrors() {return errors;}

    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setId(int id) {this.id = id;}
    public void setIpAddress(String ipAddress) {this.ipAddress = ipAddress;}
    public void setDeviceName(String deviceName) {this.deviceName = deviceName;}
    public void setOs(String os) {this.os = os;}
    public void setStartConnection(String startConnection) {this.startConnection = startConnection;}
    public void setEndConnection(String endConnection) {this.endConnection = endConnection;}
    public void setErrors(List<Errors> errors) {this.errors = errors;}
}
