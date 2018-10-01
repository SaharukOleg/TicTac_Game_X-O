package input;

import java.util.Scanner;

public class Check_input {
    //  для кольору
    public static final String ANSI_RED = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static Scanner input = new Scanner(System.in);

    private static Scanner getScanner() {
        if (input == null) {
            input = new Scanner(System.in);
        }
        return input;
    }


    public static int getIntNumber() {
        String str;
        while (true) {
            str = getScanner().nextLine();
            if (str.matches("\\d+")) {
                return Integer.parseInt(str);
            }
            System.out.println(ANSI_RED + "Помилка, введіть цифру від 1 до 3 ! " + ANSI_RESET);
        }
    }

}
