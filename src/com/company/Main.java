package com.company;

import ca.as2.ui.UIPrinter;
import ca.as2.ui.UIReader;

import java.util.List;

public class Main {

    private static boolean end;

    public static void main(String[] args) {
        end = false;
        List<List<BoardObject>> boardMatrixTemp = MazeGenerator.generateMazeObjects();
        UIPrinter.printMaze(boardMatrixTemp);
        PositionManager positionManager = new PositionManager();
        while (!end){
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
        end = true;
    }
}
