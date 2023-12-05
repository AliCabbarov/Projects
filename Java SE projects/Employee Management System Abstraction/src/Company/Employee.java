package Company;

public class Employee extends User{
    private String position;

    public Employee(String name, String surname, String username, String password, String department, double salary, String position) {
        super(name, surname, username, password, department, salary);
        this.position = position;
    }

    public Employee() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getInfo() {
        return super.getInfo()+
                "\nposition: " + position;
    }
}
