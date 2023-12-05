package service.impl;

import enums.Exception;
import enums.Status;
import exception.*;
import globalData.GlobalData;
import model.Library;
import service.LibraryService;

import static helper.LibraryServiceHelper.*;
import static helper.LibraryServiceHelper.searchHelperBySwitch;
import static util.InputUtil.*;
import static util.MenuUtil.*;
import static util.MenuUtil.SearchMenu;
public class LibraryServiceImpl implements LibraryService {


    @Override
    public void register() {
        boolean isTrue = false;
        byte count = inputByte("how many register: ");
        if (GlobalData.libraries == null) {
            GlobalData.libraries = new Library[count];
            for (int i = 0; i < GlobalData.libraries.length; i++) {
                isTrue = appropriationBook();
            }
        } else {
            Library[] tempLibrary = GlobalData.libraries;
            GlobalData.libraries = new Library[GlobalData.libraries.length + count];
            for (int i = 0; i < GlobalData.libraries.length; i++) {
                if (i < tempLibrary.length) {
                    GlobalData.libraries[i] = tempLibrary[i];
                } else {
                    isTrue = appropriationBook();
                }
            }
        }
        if (isTrue) {
            System.out.println(Status.REGISTER_SUCCESSFULLY.name());
        }
       deleteNullBook();
    }

    @Override
    public void show() {
        if (GlobalData.libraries != null) {
            byte option = viewMenu();
            switch (option) {
                case 1:
                    showHelper((byte) 0);
                    break;
                case 2:
                    showHelper((byte) 1);
                    break;
                default:
                    throw new InvalidOptionException(Exception.INVALI_OPTION_EXCEPTION);
            }
        } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
    }

    @Override
    public void search() {
        if (GlobalData.libraries != null) {
            byte option = viewMenu();
            switch (option) {
                case 1:
                    byte optionSearchMenuBase = SearchMenu();
                    searchHelperBySwitch(optionSearchMenuBase,(byte) 0);
                    break;
                case 2:
                    byte optionSearchMenuStock = SearchMenu();
                    searchHelperBySwitch(optionSearchMenuStock, (byte) 1);
                    break;
                default:
                    throw new InvalidOptionException(Exception.INVALI_OPTION_EXCEPTION);
            }
        } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);


    }

    @Override
    public boolean update() {
        if (GlobalData.libraries != null) {
            boolean isTrue = false;
            try {
                long updateById = inputLong("update by id (Book): ");
                for (int i = 0; i < GlobalData.libraries.length; i++) {
                    if (GlobalData.libraries[i].getId() == updateById) {
                        String[] parameters = updateMenu().split(",");
                        for (String parameter : parameters) {
                            switch (parameter) {
                                case "name":
                                    String updateName = inputString("update name: ");
                                    GlobalData.libraries[i].setName(updateName);
                                    isTrue = true;
                                    break;
                                case "author":
                                    String updateAuthor = inputString("update author: ");
                                    GlobalData.libraries[i].setAuthor(updateAuthor);
                                    isTrue = true;
                                    break;
                                case "genre":
                                    String updateGenre = inputString("update genre: ");
                                    GlobalData.libraries[i].setGenre(updateGenre);
                                    isTrue = true;
                                    break;
                                case "pageCount":
                                    int updatePageCount = inputInt("update page count: ");
                                    GlobalData.libraries[i].setPageCount(updatePageCount);
                                    isTrue = true;
                                    break;
                                case "language":
                                    String updateLanguage = inputString("update language: ");
                                    GlobalData.libraries[i].setLanguage(updateLanguage);
                                    isTrue = true;
                                    break;
                                case "price":
                                    double updatePrice = inputDouble("update price: ");
                                    GlobalData.libraries[i].setPrice(updatePrice);
                                    isTrue = true;
                                    break;
                                case "count":
                                    int updateCount = inputInt("update count: ");
                                    GlobalData.libraries[i].setCount(updateCount);
                                    isTrue = true;
                                    break;
                                default:
                                    throw new InvalidOptionException(Exception.INVALI_OPTION_EXCEPTION);
                            }
                        }
                    }
                }
            } catch (RuntimeException exception) {
                System.err.println(Exception.WRONG_FORMAT_EXCEPTION.getMessage());
            }
            if (isTrue) {
                System.out.println(Status.UPDATE_SUCCESSFULLY.name());
            } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
        } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
        return false;
    }

    @Override
    public boolean delete() {
        if (GlobalData.libraries != null) {
            boolean isTrue = false;
            long deleteId = inputLong("enter the delete id: ");
            for (int i = 0; i < GlobalData.libraries.length; i++) {
                if (GlobalData.libraries[i].getId() == deleteId) {
                    isTrue = true;
                    deleteBookHelper(i);
                    oneMinusBookCountIndex();
                }
            }
            if (isTrue) {
                System.out.println(Status.DELETE_SUCCESSFULLY.name());
            } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
            zeroBookIndex();
        } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
        return false;
    }
    @Override
    public void storageToStock() {
        if (GlobalData.libraries != null) {
            boolean isTrue = false;
            int storageStockId = inputInt("Storage book id: ");
            for (int i = 0; i < GlobalData.libraries.length; i++) {
                if (GlobalData.libraries[i].getId() == storageStockId) {
                    byte newStorageStatus = inputByte("write new status: ");
                    if (newStorageStatus != 0 && newStorageStatus != 1) {
                        throw new WrongStorageStatusException(Exception.WRONG_STORAGE_STATUS_EXCEPTION);
                    }
                    GlobalData.libraries[i].setStockStatus(newStorageStatus);
                    isTrue = true;
                }
            }
            if (isTrue) {
                System.out.println(Status.UPDATE_SUCCESSFULLY.name());
            } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
        } else throw new BookNotFoundException(Exception.BOOK_NOT_FOUND_EXCEPTION);
    }
}
