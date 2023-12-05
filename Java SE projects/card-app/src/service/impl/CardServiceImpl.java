package service.impl;

import data.GlobalData;
import enums.ExceptionEnums;
import exception.ApplicationException;
import model.User;
import service.CardService;

import java.text.DecimalFormat;

import static serviceHelper.serviceHelper.*;
import static util.InputUtil.inputDouble;
import static util.InputUtil.inputString;

public class CardServiceImpl implements CardService {

    @Override
    public void CardToCard(int id) {
        String receiverCardNumber = inputString("enter the transfer card: ");
        double transferMoney = inputDouble("enter the transfer money: ");
        boolean receiverDoesntExist = false;
        User senderAccount = null;
        User receiverAccount = null;
        for (User user : GlobalData.users) {
            if (user.getId() == id) {
                senderAccount = user;
                if (senderAccount.getCard().getAmount() < transferMoney + fee(transferMoney)) {
                    throw new ApplicationException(ExceptionEnums.LOW_BALANCE_EXCEPTION);
                }
            }
            if (user.getCard().getCardNumber().equals(receiverCardNumber)) {
                receiverAccount = user;
                receiverDoesntExist = true;
            }
        }
        if (receiverAccount == senderAccount) {
            throw new ApplicationException(ExceptionEnums.SAME_CARD_EXCEPTION);
        }
        if (receiverDoesntExist) {
            changeBalance(senderAccount.getCard(), true, transferMoney);
            changeBalance(receiverAccount.getCard(), false, transferMoney);
            Notification(transferMoney, receiverCardNumber, senderAccount);
            setOperationUser(senderAccount, receiverAccount, transferMoney);
        } else {
            throw new ApplicationException(ExceptionEnums.WRONG_CARD_NUMBER_EXCEPTION);
        }

    }

    @Override
    public void showBalance(int id) {
        for (User user : GlobalData.users) {
            if (user.getId() == id) {

                DecimalFormat decimalFormat = new DecimalFormat("##.#");
                System.out.println("--------------------------------\n Dear customer your balance: " +
                        decimalFormat.format(user.getCard().getAmount()));

            }

        }

    }

    @Override
    public void showOperations(int id) {
        for (User user : GlobalData.users) {
            if (user.getId() == id) {
                if (user.getOperation() != null) {
                    for (int i = 0; i < user.getOperation().length; i++) {
                        System.out.println(user.getOperation()[i].toString());
                    }
                } else throw new ApplicationException(ExceptionEnums.OPERATION_NOT_FOUND_EXCEPTION);
            }

        }

    }


}
