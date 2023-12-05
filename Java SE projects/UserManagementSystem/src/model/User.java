package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private  LocalDateTime registerDate;
    private  LocalDateTime updateDate;

    public User(long id, String name, String surname, LocalDate birthday, LocalDateTime registerDate, LocalDateTime updateDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
