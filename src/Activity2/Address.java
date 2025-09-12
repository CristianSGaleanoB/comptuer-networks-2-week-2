package src.Activity2;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
class Address {
    @XmlElement
    private String country;

    @XmlElement
    private String state;

    @XmlElement
    private String city;

    @XmlElement
    private String street;

    @XmlElement
    private String number;

    public Address() {}

    public Address(String country, String state, String city, String street, String number) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}

    public String getNumber() {return number;}
    public void setNumber(String number) {this.number = number;}
}
