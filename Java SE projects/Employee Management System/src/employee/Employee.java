package employee;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String position;
    private Double salary;
public Employee(){

}
public Employee(int id, String name, String surname, String position,Double salary){
this.id=id;
this.name=name;
this.surname=surname;
this.position= position;
this.salary=salary;
}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Double getSalary() {
        return salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(Double salary) {
    this.salary=salary;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getInfo(){
    return "employee id: " + id + "\n" +
            "name: " + name + "\n" +
            "surname: " + surname + "\n" +
            "position: " + position + "\n" +
            "Salary: " + salary;
    }
    public String salaryString(){
    String salary = String.valueOf(getSalary());
    return salary;
    }


}
