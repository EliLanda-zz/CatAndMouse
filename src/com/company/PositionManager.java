package com.company;

import ca.as2.ui.UIPrinter;
import com.sun.istack.internal.Nullable;

import java.util.List;

/**
 * Created by Matvei on 2017-02-21.
 */
public class PositionManager {
    private int amountOfCheeseCollected;

    public PositionManager()
    {
        amountOfCheeseCollected = 0;
    }

    public  List<List<BoardObject>> updateMaze(List<List<BoardObject>> maze, String command) {
        if (command == "show map") {
            for (List<BoardObject> row : maze) {
                for (BoardObject object : row) {
                    object.setVisible(true);
                }
            }
        }
        else {
            BoardObject mouse = getMouse(maze);
            if (command == "up")
                move(maze, mouse, maze.get(mouse.getY() - 1).get(mouse.getX()));
            else if (command == "left")
                move(maze, mouse, maze.get(mouse.getY()).get(mouse.getX() - 1));
            else if (command == "down")
                move(maze, mouse, maze.get(mouse.getY() + 1).get(mouse.getX()));
            else if (command == "right")
                move(maze, mouse, maze.get(mouse.getY()).get(mouse.getX() + 1));
        }
        return maze;
    }

    @Nullable
    private BoardObject getMouse(List<List<BoardObject>> maze) {
        for (List<BoardObject> row : maze) {
            for (BoardObject object : row) {
                if (object.isMouse())
                    return object;
            }
        }
        return null;
    }

    private void move(List<List<BoardObject>> maze, BoardObject mouse, BoardObject destination) {
        if (destination.isTraversable()) {
            mouse.setX(destination.getX());
            mouse.setY(destination.getY());
            maze.get(mouse.getY() - 1).get(mouse.getX()).setVisible(true);
            maze.get(mouse.getY() - 1).get(mouse.getX() + 1).setVisible(true);
            maze.get(mouse.getY()).get(mouse.getX() + 1).setVisible(true);
            maze.get(mouse.getY() + 1).get(mouse.getX() + 1).setVisible(true);
            maze.get(mouse.getY() + 1).get(mouse.getX()).setVisible(true);
            maze.get(mouse.getY() + 1).get(mouse.getX() - 1).setVisible(true);
            maze.get(mouse.getY()).get(mouse.getX() - 1).setVisible(true);
            maze.get(mouse.getY() - 1).get(mouse.getX() - 1).setVisible(true);
        } else {
            UIPrinter.printMessage("You cannot go through wall!");
        }
    }
}