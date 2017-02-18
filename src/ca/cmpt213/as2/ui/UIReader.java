package ca.cmpt213.as2.ui;
import java.util.Scanner;

/**
 * Created by Matvei on 2017-02-17.
 */
public class UIReader {
    final private static String[] validInputs = {"w", "a", "s", "d", "m", "?"};
    public static String scanInput() {
        boolean valid = false;
        String input = "";
        while (!valid) {
            System.out.print("Please enter your move:>");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            input = input.toLowerCase();
            valid = isValid(input);
            if (!valid) {
                System.out.println("Invalid value! please enter again!\n");
            }
        }
        String returnValue;
        switch(input.toLowerCase()) {
            case "w":
                returnValue = "up";
                break;
            case "a":
                returnValue = "left";
                break;
            case "s":
                returnValue = "down";
                break;
            case "d":
                returnValue = "right";
                break;
            case "m":
                returnValue = "show map";
                break;
            case "?":
                UIPrinter.printInstructions();
                returnValue = "repeat";
                break;
            default: //should never happen
                System.out.println("Invalid value! please enter again!\n");
                returnValue = "repeat";
                break;
        }
        return returnValue;
    }

    private static boolean isValid(String input) {
        for(String option : validInputs){
            if (input.equals(option))
                return true;
        }
        return false;
    }
}
