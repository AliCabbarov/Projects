package model;

import java.time.LocalDateTime;

public class Operation {
    private long id;
    private String senderCard;
    private String receiverCard;
    private double amount;
    private LocalDateTime operationTime;

    public Operation(long id, String senderCard, String receiverCard, double amount, LocalDateTime operationTime) {
        this.id = id;
        this.senderCard = senderCard;
        this.receiverCard = receiverCard;
        this.amount = amount;
        this.operationTime = operationTime;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", senderCard='" + senderCard.substring(0,4) +" **** **** "  + senderCard.substring(12,16) + '\'' +
                ", receiverCard='" + receiverCard.substring(0,4) +" **** **** "  + receiverCard.substring(12,16) + '\'' +
                ", amount=" + amount +
                ", operationTime=" + operationTime +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getSenderCard() {
        return senderCard;
    }

    public String getReceiverCard() {
        return receiverCard;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }
}
