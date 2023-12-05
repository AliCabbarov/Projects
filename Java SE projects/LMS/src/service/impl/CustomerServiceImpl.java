package service.impl;

import enums.Exception;
import enums.Status;
import enums.ExceptionCustomer;
import exception.BookNotFoundException;
import exception.InvalidOptionException;
import exception.CustomerNotFoundException;
import globalData.GlobalData;
import model.Customer;
import service.CustomerService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static helper.CustomerServiceHelper.*;
import static helper.LibraryServiceHelper.buyBookMethode;
import static util.InputUtil.inputInt;
import static util.InputUtil.inputString;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void register() {
        boolean isTrue = false;
        int count = inputInt("How many register: ");
        if (GlobalData.customers == null) {
            GlobalData.customers = new Customer[count];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                isTrue = appropriationCustomer();
            }
        } else {
            Customer[] tempCustomer = GlobalData.customers;
            GlobalData.customers = new Customer[GlobalData.customers.length + count];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (i < tempCustomer.length) {
                    GlobalData.customers[i] = tempCustomer[i];
                } else {
                    isTrue = appropriationCustomer();
                }

            }
        }
        if (isTrue) {
            System.out.println(Status.REGISTER_SUCCESSFULLY);
        }
        deleteNullCustomer();
    }

    @Override
    public void show() {
        if (GlobalData.customers != null) {
            for (int i = 0; i < GlobalData.customers.length; i++) {
                System.out.println(GlobalData.customers[i].getInfo());
            }
            boolean isTrue = false;
            System.out.println("detailed Information Customer!");
            String name = inputString("enter the customer name: ");
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (GlobalData.customers[i].getName().equals(name)) {
                    System.out.println(GlobalData.customers[i].toString());
                    isTrue = true;
                }
            }
            if (!isTrue) throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
        } else throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
    }

    @Override
    public boolean update() {
        if (GlobalData.customers != null) {
            boolean isTrue1 = false;
            boolean isTrue = false;
            int updateId = inputInt("enter the update customer id: ");
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (GlobalData.customers[i].getId() == updateId) {
                    isTrue1 = true;
                    String parameters = inputString("enter the update field (exp: name,surname)): ");
                    String[] parameter = parameters.split(",");
                    for (String field : parameter) {
                        switch (field) {
                            case "name":
                                String updateName = inputString("enter the update name: ");
                                GlobalData.customers[i].setName(updateName);
                                GlobalData.customers[i].setUpdateTime(LocalDateTime.now());
                                isTrue = true;
                                break;
                            case "surname":
                                String updateSurname = inputString("enter the update surname: ");
                                GlobalData.customers[i].setSurname(updateSurname);
                                GlobalData.customers[i].setUpdateTime(LocalDateTime.now());
                                isTrue = true;
                                break;
                            case "birthday:":
                                LocalDate updateBirthday = birthdayFormat();
                                GlobalData.customers[i].setBirthday(updateBirthday);
                                GlobalData.customers[i].setUpdateTime(LocalDateTime.now());
                                isTrue = true;
                                break;
                            case "username":
                                String updateUsername = inputString("enter the update username: ");
                                GlobalData.customers[i].setUsername(updateUsername);
                                GlobalData.customers[i].setUpdateTime(LocalDateTime.now());
                                isTrue = true;
                                break;
                            default:
                                throw new InvalidOptionException(Exception.INVALI_OPTION_EXCEPTION);
                        }
                    }
                }
            }
            if (!isTrue1) throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
            if (isTrue) System.out.println(Status.UPDATE_SUCCESSFULLY);

        } else throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
        return false;
    }

    @Override
    public boolean delete() {
        if (GlobalData.customers != null) {
            boolean isTrue = false;
            int deleteId = inputInt(" enter the delete id: ");
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (GlobalData.customers[i].getId() == deleteId) {
                    isTrue = true;
                    Customer[] tempCustomer = new Customer[GlobalData.customers.length - 1];
                    for (int j = 0; j < GlobalData.customers.length; j++) {
                        if (j < i) {
                            GlobalData.customers[j] = tempCustomer[j];
                        } else
                            GlobalData.customers[j] = tempCustomer[j + 1];
                    }
                    oneMinusCountIndex();
                }
            }
            zeroCountIndex();
            if (isTrue) System.out.println(Status.DELETE_SUCCESSFULLY);
            else throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
        } else throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
        return false;
    }

    @Override
    public void search() {
        if (GlobalData.customers != null) {
            boolean isTrue = false;
            String key = inputString("enter the search key: (byName, by surname, by username): ");
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (GlobalData.customers[i].getName().equals(key) ||
                        GlobalData.customers[i].getSurname().equals(key) ||
                        GlobalData.customers[i].getUsername().equals(key)) {
                    isTrue = true;
                    System.out.println(GlobalData.customers[i].toString());
                }
            }
            if (!isTrue) {
                throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
            }
        } else
            throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
    }

    @Override
    public void login() {
        if (GlobalData.libraries != null) {
            String username = inputString("enter the username for login: ");
            boolean isTrue = false;
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (GlobalData.customers[i].getUsername().equals(username)) {
                    isTrue = true;
                    System.out.println("welcome to " + GlobalData.customers[i].getUsername());
                    buyBookMethode(i);
                }
            }
            if (!isTrue) throw new CustomerNotFoundException(ExceptionCustomer.CUSTOMER_NOT_FOUND_EXCEPTION);
        } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);

    }
}
