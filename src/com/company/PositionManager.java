package com.company;

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
            if (destination.getType() == "cheese") {
                amountOfCheeseCollected++;
            } else if (destination.getType() == "cat") {
                Main.endGame(false);
            }
            mouse.setType("empty");
            destination.setType("mouse");
            maze.get(mouse.getY() - 1).get(mouse.getX()).setVisible(true);
            maze.get(mouse.getY() - 1).get(mouse.getX() + 1).setVisible(true);
            maze.get(mouse.getY()).get(mouse.getX() + 1).setVisible(true);
            maze.get(mouse.getY() + 1).get(mouse.getX() + 1).setVisible(true);
            maze.get(mouse.getY() + 1).get(mouse.getX()).setVisible(true);
            maze.get(mouse.getY() + 1).get(mouse.getX() - 1).setVisible(true);
            maze.get(mouse.getY()).get(mouse.getX() - 1).setVisible(true);
            maze.get(mouse.getY() - 1).get(mouse.getX() - 1).setVisible(true);

            if (amountOfCheeseCollected == 5){
                Main.endGame(true);
            }
        } else {
            ca.as2.ui.UIPrinter.printMessage("You cannot go through wall!");
        }
    }
}