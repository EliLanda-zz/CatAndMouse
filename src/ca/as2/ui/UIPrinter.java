package ca.as2.ui;

import com.company.BoardObjects;

import java.util.List;

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

    public static void printMaze(List<List<BoardObjects>> boardMatrix) { //Is it a string in the end?
        String mazeStr = "";
        String cellChar = "";
        for(int k = 0; k < 10; k ++) {
            for (int i = 0; i < 10; i++) {

                if(boardMatrix.get(k).get(i).getType() == "wall"){
                    cellChar = "w";
                }
                else if (boardMatrix.get(k).get(i).getType() == "cheese"){
                    cellChar = "c";
                }
                else if (boardMatrix.get(k).get(i).getType() == "player"){
                    cellChar = "p";
                }
                else {
                    cellChar = "-";
                }
                mazeStr += cellChar;
                mazeStr += " ";
            }
            mazeStr += "\n";
        }
        mazeStr += "\n \n \n \n \n";
        System.out.println(mazeStr);
    }
}
