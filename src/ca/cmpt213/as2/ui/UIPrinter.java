package ca.cmpt213.as2.ui;

/**
 * Created by Matvei on 2017-02-17.
 */
public class UIPrinter {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printInstructions() {
        System.out.println("**************************\n" +
                "Welcome to the Cat and Mouse maze game!\n" +
                "You are a mouse ('@')\n" +
                "You cannot go through walls ('#')\n" +
                "You want to find cheese ('$')\n" +
                "If you step on a cat ('!'), you die!\n" +
                "If you collect 4 pieces of cheese, you win!\n" +
                "Enter 'w' to go up\n" +
                "Enter 'd' to go down\n" +
                "Enter 'a' to go left\n" +
                "Enter 'd' to go right\n" +
                "Enter 'm' to unlock the whole map (but that's cheating!)\n" +
                "Enter '?' to see rules again\n" +
                "Good luck!\n" +
                "**************************\n");
    }

    public static void printMaze(String maze) { //Is it a string in the end?
        System.out.println(maze);
    }
}
