package src.Activity2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlElement
    private String name;

    @XmlElement
    private String lastName;

    @XmlElement
    private String grade;

    @XmlElement
    private int id;

    @XmlElement
    private int age;

    @XmlElement
    private Address address;

    @XmlElement
    private String phone;

    public Student() {}

    public Student(String name, String lastName, String grade, int id, int age, Address address, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
        this.id = id;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getGrade() {return grade;}
    public void setGrade(String grade) {this.grade = grade;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
}
