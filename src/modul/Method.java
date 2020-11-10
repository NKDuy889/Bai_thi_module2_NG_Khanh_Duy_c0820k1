package modul;

import danhba.DanhBa;
import util.ParseUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Method {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


    private List<DanhBa> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    DanhBa db = new DanhBa();

    public void add() {
        int phoneNumber;
        do {
            System.out.println("Enter phone number: ");
            phoneNumber = (Integer) ParseUtils.parseFromScanner(Integer.class, "(09|01[2|6|8|9])+([0-9]{8})\\b");
            db.setPhoneNumber(phoneNumber);
        } while (checkPhoneNumbers(phoneNumber));
        System.out.println("Enter name");
        db.setName((String) ParseUtils.parseFromScanner(String.class));
        System.out.println("Enter gender(male/female)");
        db.setGender((String) ParseUtils.parseFromScanner(String.class));
        System.out.println("Enter address");
        db.setAddress((String) ParseUtils.parseFromScanner(String.class));
        System.out.println("Enter date of birth(dd/MM/yyyy)");
        db.setDateOfBirth((Date) ParseUtils.parseFromScanner(Date.class));
        System.out.println("Enter email");
        db.setEmail((String) ParseUtils.parseFromScanner(String.class, "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"));
        list.add(db);
    }

    public void show() {
        for (DanhBa person : list) {
            System.out.println(person);
        }
    }

    public boolean checkPhoneNumbers(int phoneNumber) {
        for (DanhBa person : list) {
            if (person.getPhoneNumber() == phoneNumber) {
                System.out.println("Id exist. Try again: ");
                return true;
            }
        }
        return false;
    }

    public DanhBa getPerSonByPhoneNumber() {
        if (list.isEmpty()) {
            System.out.println("                    -----  List is empty  -----");
            return null;
        }
        System.out.println("Enter phone number: ");
        int phoneNumber = (Integer) ParseUtils.parseFromScanner(Integer.class, "(09|01[2|6|8|9])+([0-9]{8})\\b");
        for (DanhBa person : list) {
            if (phoneNumber == person.getPhoneNumber()) {
                return person;
            }
        }
        System.out.println("Don't have this phone number. Try again ");
        return getPerSonByPhoneNumber();
    }

    public void changeName() {
        DanhBa person = getPerSonByPhoneNumber();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setName(sc.next());
        }
    }

    public void changePhoneNumber() {
        DanhBa person = getPerSonByPhoneNumber();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setPhoneNumber((Integer) ParseUtils.parseFromScanner(Integer.class, "(09|01[2|6|8|9])+([0-9]{8})\\b"));
        }
    }

    public void changeAddress() {
        DanhBa person = getPerSonByPhoneNumber();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setAddress(sc.next());
        }
    }


    public void changeGender() {
        DanhBa person = getPerSonByPhoneNumber();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setGender(sc.next());
        }
    }

    public void changeDateOfBirth() {
        DanhBa person = getPerSonByPhoneNumber();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setDateOfBirth((Date) ParseUtils.parseFromScanner(Date.class));
        }
    }

    public void changeEmail() {
        DanhBa person = getPerSonByPhoneNumber();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            person.setEmail((String) ParseUtils.parseFromScanner(String.class, "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"));
        }
    }

    public void delete() {
        DanhBa person = getPerSonByPhoneNumber();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            list.remove(person);
        }
    }

    public void findPerson() {
        DanhBa person = getPerSonByPhoneNumber();
        if (!Objects.isNull(person)) {
            System.out.println("Rename to: ");
            System.out.println(person);
        }
    }

    public void writeToFile() {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("src/file.csv");

            for (DanhBa person : list) {
                fileWriter.append(person.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((char) person.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getGender());
                fileWriter.append(NEW_LINE_SEPARATOR);
//                fileWriter.append((CharSequence) person.getDateOfBirth());
            }

            System.out.println("CSV file was created successfully !!!");
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

}

