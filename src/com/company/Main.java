package com.company;

import ca.as2.ui.UIPrinter;
import ca.as2.ui.UIReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        boolean won = false;
        List<List<BoardObject>> boardMatrixTemp = MazeGenerator.generateMazeObjects();
        UIPrinter.printMaze(boardMatrixTemp);
        PositionManager positionManager = new PositionManager();
        while (!won){
            boardMatrixTemp = positionManager.updateMaze(boardMatrixTemp,UIReader.scanInput());
            UIPrinter.printMaze(boardMatrixTemp);
        }
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
