package helper;

import enums.Exception;
import enums.Status;
import exception.BookNotFoundException;
import exception.InvalidOptionException;
import exception.WrongNameException;
import globalData.GlobalData;
import model.Library;
import static util.InputUtil.*;

public class LibraryServiceHelper {
    private static int bookIndex = 0;
    private static long id;

    public static Library fillBook() {
        try {
            String name = inputString("book name: ");
            String author = inputString("author name: ");
            String genre = inputString("genre: ");
            int pageCount = inputInt("page count: ");
            String language = inputString("book language: ");
            double price = inputDouble("book price: ");
            int count = inputInt("book count: ");
            byte stockStatus = inputByte("book status((0 = base) , (1 = stock)): ");
            if (stockStatus != 0 && stockStatus != 1) {
                stockStatus = 0;
            }
            return new Library(++id, name, author, genre, pageCount, language, price, count, stockStatus, true);
        } catch (RuntimeException exception) {
            System.err.println(Exception.WRONG_FORMAT_EXCEPTION.getMessage());
            return null;
        }
    }


    public static void searchByName(byte stockStatus) {
        String name = inputString("enter the name: ");
        boolean isTrue = false;
        for (int i = 0; i < GlobalData.libraries.length; i++) {
            if (GlobalData.libraries[i].getName().equals(name) && GlobalData.libraries[i].getStockStatus() == stockStatus) {
                System.out.println(GlobalData.libraries[i].toString());
                isTrue = true;
            }
        }
        if (!isTrue) {
            throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
        }
    }

    public static void searchByAuthor(byte stockStatus) {
        String author = inputString("enter the author: ");
        boolean isTrue = false;
        for (int i = 0; i < GlobalData.libraries.length; i++) {
            if (GlobalData.libraries[i].getAuthor().equals(author) && GlobalData.libraries[i].getStockStatus() == stockStatus) {
                System.out.println(GlobalData.libraries[i].toString());
                isTrue = true;
            }
        }
        if (!isTrue) {
            throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
        }
    }

    public static void searchByGenre(byte stockStatus) {
        String genre = inputString("enter the genre: ");
        boolean isTrue = false;
        for (int i = 0; i < GlobalData.libraries.length; i++) {
            if (GlobalData.libraries[i].getGenre().equals(genre) && GlobalData.libraries[i].getStockStatus() == stockStatus) {
                System.out.println(GlobalData.libraries[i].toString());
                isTrue = true;
            }
        }
        if (!isTrue) {
            throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
        }
    }

    public static void searchHelperBySwitch(byte optionSearchMenuStock, byte stockStatus) {
        switch (optionSearchMenuStock) {
            case 1:
                searchByName(stockStatus);
                break;
            case 2:
                searchByAuthor(stockStatus);
                break;
            case 3:
                searchByGenre(stockStatus);
                break;
            default:
                throw new InvalidOptionException(Exception.INVALI_OPTION_EXCEPTION);
        }
    }


    public static void showHelper(byte stockStatus) {
        boolean isTrue = false;
        for (int i = 0; i < GlobalData.libraries.length; i++) {
            if (GlobalData.libraries[i].getStockStatus() == stockStatus) {
                GlobalData.libraries[i].getInfo();
                isTrue = true;
            }

        }
        if (isTrue) {
            boolean wrongNameIsTrue = false;
            System.out.println("detailed Information Book!");
            String detailedBookNameBase = inputString("Enter the book name: ");
            for (int i = 0; i < GlobalData.libraries.length; i++) {
                if (GlobalData.libraries[i].getName().equals(detailedBookNameBase) && GlobalData.libraries[i].getStockStatus() == stockStatus) {
                    System.out.println(GlobalData.libraries[i].toString());
                    wrongNameIsTrue = true;
                }
            }
            if (!wrongNameIsTrue) {
                throw new WrongNameException(Exception.WRONG_NAME_EXCEPTION);
            }
        } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
    }

    public static void buyBookMethode(int i) {
        boolean isTrue = false;
        for (int j = 0; j < GlobalData.libraries.length; j++) {
            if (GlobalData.libraries[j].getCount() >= 1 && GlobalData.libraries[j].getStockStatus() == 1) {
                GlobalData.libraries[j].getInfo();
                isTrue = true;
            }
        }
        if (isTrue) {
            buy(i);
        }else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
    }

    public static void buy(int i) {
        String bookName = inputString("enter the buy book name: ");
        boolean isTrue = false;
        for (int j = 0; j < GlobalData.libraries.length; j++) {
            if (GlobalData.libraries[j].getName().equals(bookName) && GlobalData.libraries[j].getStockStatus() == 1 && GlobalData.libraries[j].getCount() >= 1) {
                GlobalData.customers[i].setBookId(GlobalData.libraries[j].getId());
                GlobalData.libraries[j].setBookStatus(false);
                GlobalData.libraries[j].setCount(GlobalData.libraries[j].getCount() - 1);
                isTrue = true;
            }
        }
        if(isTrue){
            System.out.println(Status.BOOK_BUY.name());
        }else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
    }
    public static void deleteNullBook(){
        boolean isTrue = false;
        if (isTrue) {
            System.out.println(Status.REGISTER_SUCCESSFULLY.name());
        }
        int nullCount = 0;
        for (int i = 0; i < GlobalData.libraries.length; i++) {
            if (GlobalData.libraries[i] == null) {
                nullCount++;
            }

        }
        Library[] tempLibrary = GlobalData.libraries;
        GlobalData.libraries = new Library[GlobalData.libraries.length - nullCount];
        for (int i = 0; i < GlobalData.libraries.length; i++) {
            GlobalData.libraries[i] = tempLibrary[i];
        }
        if (GlobalData.libraries.length == 0) {
            GlobalData.libraries = null;
            bookIndex = 0;
        }
    }
    public static boolean appropriationBook(){
        Library book = fillBook();
        if (book != null) {
            GlobalData.libraries[bookIndex] = book;
            bookIndex++;
            return true;
        }
        return false;
    }
    public static void oneMinusBookCountIndex() {
        bookIndex--;
    }
    public static void zeroBookIndex(){
        if (GlobalData.libraries.length == 0) {
            GlobalData.libraries = null;
            bookIndex = 0;
        }
    }
    public static void deleteBookHelper(int i){
        Library[] tempLibrary = GlobalData.libraries;
        GlobalData.libraries = new Library[GlobalData.libraries.length - 1];
        for (int j = 0; j < GlobalData.libraries.length; j++) {
            if (j < i) {
                GlobalData.libraries[j] = tempLibrary[j];
            } else {
                GlobalData.libraries[j] = tempLibrary[j + 1];
            }
        }
    }
}
