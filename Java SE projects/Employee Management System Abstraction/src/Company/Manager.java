package Company;

public class Manager extends User{
    private String experienceInYear;

    public Manager(String name, String surname, String username, String password, String department, double salary, String experienceInYear) {
        super(name, surname, username, password, department, salary);
        this.experienceInYear = experienceInYear;
    }

    public Manager() {
    }

    public String getExperienceInYear() {
        return experienceInYear;
    }

    public void setExperienceInYear(String experienceInYear) {
        this.experienceInYear = experienceInYear;
    }

    @Override
    public String getInfo() {
        return super.getInfo()+
                "\nexperienceYear:" + experienceInYear;
    }
}
