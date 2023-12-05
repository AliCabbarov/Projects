package serviceHelper;

import model.Card;
import model.Operation;
import model.User;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class serviceHelper {
    private static long operationId = 0;

    public static void changeBalance(Card card, boolean isSender, double transferMoney) {
        double newAmount = isSender ? card.getAmount() - transferMoney - fee(transferMoney) : card.getAmount() + transferMoney;
        card.setAmount(newAmount);

    }

    public static int fee(double transferMoney) {
        return (int) (transferMoney / 100 + 1);
    }

    public static void Notification(double transferMoney, String receiverCardNumber, User senderAccount) {
        DecimalFormat decimalFormat = new DecimalFormat("##.#");
        System.out.println("Transfer money: " + transferMoney +
                "\nCommission: " + fee(transferMoney) +
                "\nReceiver Card: " + receiverCardNumber.substring(0, 4) + " **** **** " + receiverCardNumber.substring(12, 16) +
                "\nYour balance is: " + decimalFormat.format(senderAccount.getCard().getAmount()));
    }
    public static void setOperationUser(User senderAccount, User receiverAccount,double transferMoney){
        if (senderAccount.getOperation() == null) {
            Operation[] operations = new Operation[]{
                    new Operation(++operationId, senderAccount.getCard().getCardNumber(), receiverAccount.getCard().getCardNumber(), transferMoney, LocalDateTime.now())
            };
            senderAccount.setOperation(operations);
        } else {
            Operation[] operations = new Operation[senderAccount.getOperation().length + 1];
            for (int i = 0; i < operations.length; i++) {
                if (i < senderAccount.getOperation().length) {
                    operations[i] = senderAccount.getOperation()[i];
                } else {
                    operations[i] = new Operation(++operationId, senderAccount.getCard().getCardNumber(), receiverAccount.getCard().getCardNumber(), transferMoney, LocalDateTime.now());
                }
            }
            senderAccount.setOperation(operations);
        }
    }
}
