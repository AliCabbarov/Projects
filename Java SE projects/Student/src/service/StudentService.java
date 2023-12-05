package service;

import global.GlobalData;
import model.Student;
import util.InputUtil;
import util.MenuUtil;

public class StudentService {
    public void registerStudent() {
        int registerCount = InputUtil.inputRequiredInt("how many Students: ");
        if (GlobalData.students == null) {
            GlobalData.students = new Student[registerCount];
            for (int i = 0; i < GlobalData.students.length; i++) {
                GlobalData.students[i] = fillStudent();
            }
        } else {
            Student[] tempStudent = GlobalData.students;
            GlobalData.students = new Student[GlobalData.students.length + registerCount];
            for (int i = 0; i < GlobalData.students.length; i++) {
                if (i < tempStudent.length) {
                    GlobalData.students[i] = tempStudent[i];
                } else {
                    GlobalData.students[i] = fillStudent();
                }

            }
        }
        System.out.println("Register Successfully!!!");
    }

    public void showStudents() {
        if (GlobalData.students != null)
            for (int i = 0; i < GlobalData.students.length; i++) {
                System.out.println("------------------------------");
                System.out.println(GlobalData.students[i].getInfo());
            }
        else {
            System.out.println("student has not yet!");
        }
    }

    public void findByFullNameOrrGroupOrrSpecialty() {
        boolean isFind = false;
        if (GlobalData.students != null) {
            String key = InputUtil.inputRequiredString("Search: ");
            for (int i = 0; i < GlobalData.students.length; i++) {
                if (GlobalData.students[i].getFullName().contains(key) ||
                        GlobalData.students[i].getGroup().contains(key) ||
                        GlobalData.students[i].getSpecialty().contains(key)) {
                    isFind = true;
                    System.out.println("---------------------------------------");
                    System.out.println(GlobalData.students[i].getInfo());
                }
            }
            if (!isFind) {
                System.out.println("Student doesnt exist!!");
            }
        } else {
            System.out.println("Student has not yet!!!");
        }
    }

    public void updateStudent() {
        if (GlobalData.students != null) {
            boolean check = false;
            int updateStudentId = InputUtil.inputRequiredInt("input Update Student id: ");
            for (int i = 0; i < GlobalData.students.length; i++) {
                if (GlobalData.students[i].getId() == updateStudentId) {
                    check = true;
                    System.out.println(GlobalData.students[i].getInfo());
                    String[] fieldsSplit = MenuUtil.entryMenu2().split(", ");
                    for (int j = 0; j < fieldsSplit.length; j++) {
                        int option = Integer.valueOf(fieldsSplit[j]);
                        switch (option) {
                            case 1:
                                String updateFullName = InputUtil.inputRequiredString("new Full name: ");
                                GlobalData.students[i].setFullName(updateFullName);
                                break;
                            case 2:
                                String updateGroup = InputUtil.inputRequiredString("new group: ");
                                GlobalData.students[i].setGroup(updateGroup);
                                break;
                            case 3:
                                String updateSpecialty = InputUtil.inputRequiredString("new Specialty: ");
                                GlobalData.students[i].setSpecialty(updateSpecialty);
                                break;
                            default:
                                System.out.println("invalid option!!!");
                        }
                    }
                    System.out.println("update successfully!!!");
                }
            }
            if(!check){
                System.out.println("Student has not yet!!!");
            }
        } else {
            System.out.println("Student has not yet!!!");

        }
    }

    public void deleteStudent() {
        if (GlobalData.students != null) {
            boolean check = false;
            Student[] tempStudent = GlobalData.students;
            int input = InputUtil.inputRequiredInt("Delete Student id: ");
            for (int i = 0; i < GlobalData.students.length; i++) {
                if (GlobalData.students[i].getId() == input) {
                    check = true;
                    GlobalData.students = new Student[GlobalData.students.length - 1];
                    for (int j = 0; j < GlobalData.students.length; j++) {
                        if (tempStudent[j].getId() < input) {
                            GlobalData.students[j] = tempStudent[j];
                        } else {
                            GlobalData.students[j] = tempStudent[j + 1];
                        }
                    }
                    System.out.println("delete successfully");
                }
            }
            if(!check){
                System.out.println("Student has not yet");
            }
        } else {
            System.out.println("Student has not yet!!");
        }
    }


    public Student fillStudent() {
        System.out.println("-------------------------");
        int id = InputUtil.inputRequiredInt("Student id: ");
        String fullName = InputUtil.inputRequiredString("enter the full name: ");
        String group = InputUtil.inputRequiredString("enter the group: ");
        String specialty = InputUtil.inputRequiredString("enter the specialty: ");
        return new Student(id, fullName, group, specialty);
    }


}
