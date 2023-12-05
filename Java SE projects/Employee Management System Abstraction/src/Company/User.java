package Company;

public  class User {
    private static int autoIncrement = 1;
    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String department;
    private double salary;


    public User(String name, String surname, String username, String password, String department, double salary) {
        id = autoIncrement++;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.department = department;
        this.salary = salary;
    }

    public User() {
        id = autoIncrement++;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public  String getInfo() {
        return "id:" + id+
                "\nname: " + name+
                "\nsurname: " + surname+
                "\nusername: " + username +
                "\ndepartment: " + department+
                "\nsalary: " + salary;

    }


}
