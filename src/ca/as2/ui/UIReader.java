package ca.as2.ui;
import java.util.Scanner;

/**
 * Responsible for reading user input and transferring it into game signals
 * @author Matt
 */
public class UIReader {
    final private static String[] VALID_INPUTS = {"w", "a", "s", "d", "m", "?"};
    public static String scanInput() {
        boolean valid = false;
        String input = "";
        while (!valid) {
            System.out.print("Please enter your next step:>");
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

    public static String scanRetry() {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        boolean valid = false;
        while(!valid) {
            System.out.print("Would you like to try again? (y/n): ");
            answer = scanner.nextLine();
            answer = answer.toLowerCase();
            if (answer.equals("n") || answer.equals("y")) {
                valid = true;
            } else {
                System.out.println("Invalid input!");
            }
        }
        return answer;
    }

    private static boolean isValid(String input) {
        for(String option : VALID_INPUTS){
            if (input.equals(option))
                return true;
        }
        return false;
    }
}
