package ca.as2.ui;

import com.company.BoardObject;

import java.util.List;

/**
 * Responsible for printing the data to the console
 * @author Matt and Eli
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
                "If you collect 5 pieces of cheese, you win!\n" +
                "Enter 'w' to go up\n" +
                "Enter 'd' to go down\n" +
                "Enter 'a' to go left\n" +
                "Enter 'd' to go right\n" +
                "Enter 'm' to unlock the whole map (but that's cheating!)\n" +
                "Enter '?' to see rules again\n" +
                "Good luck!\n" +
                "**************************\n");
    }

    /**
     * turns the maze into string and prints it out.
     * @param boardMatrix
     */
    public static void printMaze(List<List<BoardObject>> boardMatrix) {
        String mazeStr = "";
        String cellChar = "";
        for(int k = 0; k < 10; k ++) {
            for (int i = 0; i < 10; i++) {
                if (boardMatrix.get(k).get(i).isCheese()) {
                    cellChar = "$";
                }
                else if (boardMatrix.get(k).get(i).isCat()) {
                    cellChar = "!";
                }
                else if(boardMatrix.get(k).get(i).isVisible()) {
                    if (boardMatrix.get(k).get(i).isWall()) {
                        cellChar = "#";
                    }
                    else if (boardMatrix.get(k).get(i).isMouse()) {
                        cellChar = "@";
                    }
                    else {
                        cellChar = " ";
                    }
                }
                else {
                    cellChar = "*";
                }
                mazeStr += cellChar;
                mazeStr += " ";
            }
            mazeStr += "\n";
        }
        mazeStr += "\n";
        System.out.println(mazeStr);
    }
}
