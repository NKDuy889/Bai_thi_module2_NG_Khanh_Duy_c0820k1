package action;

public class Menu {
    public void showMenu(){
        System.out.println("MENU");
        System.out.println("1. Add person");
        System.out.println("2. Show list");
        System.out.println("3. Edit person");
        System.out.println("4. Delete person");
        System.out.println("5. Find person");
        System.out.println("6. Write to file csv");
        System.out.println("7. Read file csv");
        System.out.println("0. Exit");
    }

    public void showEditMenu(){
        System.out.println("EDIT MENU");
        System.out.println("1. Change name");
        System.out.println("2. Change address");
        System.out.println("3. Change date of birth");
        System.out.println("4. Change email");
        System.out.println("5. Change gender");
        System.out.println("6. Change phone number");
        System.out.println("0. Exit");
    }
}
