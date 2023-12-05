package model;

public class Card {
    private long id;
    private String cardNumber;
    private String cvv;
    private String date;
    private double amount;

    public Card(long id, String cardNumber, String cvv, String date, double amount) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.date = date;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }



    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }
}
