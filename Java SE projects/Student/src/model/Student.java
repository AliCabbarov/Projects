package model;

public class Student {
    private int id;
    private String fullName;
    private String group;
    private String specialty;

    public Student() {

    }


    public Student(int id, String fullName, String group, String specialty) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.specialty = specialty;
    }

    public String getInfo() {
        return "Student id: " + id + "\n" +
                "Full Name: " + fullName + "\n" +
                "Group: " + group + "\n" +
                "Specialty: " + specialty + "\n";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
