package com.company;

public class Main {

    public static void main(String[] args) {
        MazeGenerator.generateMazeObjects();
	// write your code here
    }

    public static void endGame(boolean won) {
        if (won) {
            ca.as2.ui.UIPrinter.printMessage("Way to go! You won!");
        } else {
            ca.as2.ui.UIPrinter.printMessage("Bad Luck! Try again!");
        }
    }
}
