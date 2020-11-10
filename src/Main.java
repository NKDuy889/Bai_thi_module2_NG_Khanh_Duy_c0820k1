import action.Menu;
import modul.Method;
import util.ParseUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Method method = new Method();
        Menu menu = new Menu();

        do {
            menu.showMenu();
            System.out.println("Your choice: ");
            choice = (Integer) ParseUtils.parseFromScanner(Integer.class);
            switch (choice) {
                case 1:
                    method.add();
                    break;
                case 2:
                    method.show();
                    break;
                case 3:
                    menu.showEditMenu();
                    System.out.println("Your choice");
                    int chose = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2|3|4|5|6|0");
                    switch (chose) {
                        case 1:
                            method.changeName();
                            break;
                        case 2:
                            method.changeAddress();
                            break;
                        case 3:
                            method.changeDateOfBirth();
                            break;
                        case 4:
                            method.changeEmail();
                            break;
                        case 5:
                            method.changeGender();
                            break;
                        case 6:
                            method.changePhoneNumber();
                            break;
                    }
                    break;
                case 4:
                    method.delete();
                    break;
                case 5:
                    method.findPerson();
                    break;
                case 6:
                    method.writeToFile();
            }
        } while (choice != 0);
    }
}
