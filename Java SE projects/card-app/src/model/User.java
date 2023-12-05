package model;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String surname;
    private String username;
    private String fin;
    private String password;
    private String mobileNumber;
    private Card card;
    private Operation operation[];

    public User(long id, String name, String surname, String username, String fin, String password, String mobileNumber, Card card, Operation[] operation) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.fin = fin;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.card = card;
        this.operation = operation;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Operation[] getOperation() {
        return operation;
    }

    public void setOperation(Operation[] operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(username, user.username) && Objects.equals(fin, user.fin) && Objects.equals(password, user.password) && Objects.equals(mobileNumber, user.mobileNumber) && Objects.equals(card, user.card) && Arrays.equals(operation, user.operation);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, surname, username, fin, password, mobileNumber, card);
        result = 31 * result + Arrays.hashCode(operation);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", fin='" + fin + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", card=" + card +
                ", operation=" + Arrays.toString(operation) +
                '}';
    }
}
