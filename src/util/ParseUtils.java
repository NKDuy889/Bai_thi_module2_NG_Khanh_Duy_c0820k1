package util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ParseUtils {
    public static <E extends Serializable> Object parseFromScanner(Class<E> clzz, String... pattern) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try {
            if (Integer.class.equals(clzz)) {
                if ((pattern.length > 0 && input.matches(pattern[0])) || (pattern.length == 0 && input.matches("^[0-9]{1,9}$"))) {
                    return Integer.parseInt(input);
                }
            } else if (Date.class.equals(clzz)) {
                if (pattern.length > 1) {
                    if (input.matches(pattern[1]))
                        return new SimpleDateFormat(pattern[0]).parse(input);
                } else if (input.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"))
                    return new SimpleDateFormat("dd/MM/yyyy").parse(input);
            } else if (String.class.equals(clzz)) {
                return input;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Wrong pattern. Enter again: ");
        return parseFromScanner(clzz, pattern);
    }
}
