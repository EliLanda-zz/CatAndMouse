package com.company;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Updates the board according to user input and inner algorithms of the game.
 * Counts the user's progress.
 * @author Matt
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
            if (command == "up") {
                move(maze, mouse, maze.get(mouse.getY() - 1).get(mouse.getX()));
            }
            else if (command == "left"){
                move(maze, mouse, maze.get(mouse.getY()).get(mouse.getX() - 1));
            }
            else if (command == "down") {
                move(maze, mouse, maze.get(mouse.getY() + 1).get(mouse.getX()));
            }
            else if (command == "right") {
                move(maze, mouse, maze.get(mouse.getY()).get(mouse.getX() + 1));
            }
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
        return null; // should not happen
    }

    private void move(List<List<BoardObject>> maze, BoardObject mouse, BoardObject destination) {
        if (destination.isTraversable()) {
            //mark the progress
            if (destination.getType() == "cheese") {
                amountOfCheeseCollected++;
                MazeGenerator.placeRandomObject("cheese", maze, 1);
            } else if (destination.getType() == "cat") {
                Main.endGame(false);
            }

            //move the mouse, set the area around it visible.
            mouse.setType("empty");
            mouse.setVisible(true);
            if (!(destination.getType() == "cat"))
                destination.setType("mouse");
            destination.setVisible(true);
            maze.get(destination.getY() - 1).get(destination.getX()).setVisible(true);
            maze.get(destination.getY() - 1).get(destination.getX() + 1).setVisible(true);
            maze.get(destination.getY()).get(destination.getX() + 1).setVisible(true);
            maze.get(destination.getY() + 1).get(destination.getX() + 1).setVisible(true);
            maze.get(destination.getY() + 1).get(destination.getX()).setVisible(true);
            maze.get(destination.getY() + 1).get(destination.getX() - 1).setVisible(true);
            maze.get(destination.getY()).get(destination.getX() - 1).setVisible(true);
            maze.get(destination.getY() - 1).get(destination.getX() - 1).setVisible(true);

            //move cats
            List<BoardObject> cats = new ArrayList<>();
            for (List<BoardObject> row : maze) {
                for (BoardObject object : row) {
                    if (object.isCat()){
                       cats.add(object);
                    }
                }
            }
            for (BoardObject cat : cats) {
                maze = moveCat(cat, maze);
            }

            //end the game if we won
            if (amountOfCheeseCollected == 5){
                Main.endGame(true);
            }
        } else {
            ca.as2.ui.UIPrinter.printMessage("You cannot go through wall!");
        }
    }

    private List<List<BoardObject>> moveCat(BoardObject cat, List<List<BoardObject>> maze) {
        //check where we can go, then go
        List<BoardObject> possibleMoves = new ArrayList<>();
        if(maze.get(cat.getY() - 1).get(cat.getX()).isTraversable()){
            possibleMoves.add(maze.get(cat.getY() - 1).get(cat.getX()));
        }
        if(maze.get(cat.getY() + 1).get(cat.getX()).isTraversable()){
            possibleMoves.add(maze.get(cat.getY() + 1).get(cat.getX()));
        }
        if(maze.get(cat.getY()).get(cat.getX() + 1).isTraversable()){
            possibleMoves.add(maze.get(cat.getY()).get(cat.getX() + 1));
        }
        if(maze.get(cat.getY()).get(cat.getX() - 1).isTraversable()){
            possibleMoves.add(maze.get(cat.getY()).get(cat.getX() - 1));
        }
        if (!possibleMoves.isEmpty()) {
            Random random = new Random();
            int randVal = random.nextInt(possibleMoves.size());
            BoardObject dest = possibleMoves.get(randVal);
            if (cat.getType() == "cat on cheese") {
                cat.setType("cheese");
            } else if (cat.getType() == "triple cat") {
                cat.setType("double cat");
            } else if (cat.getType() == "double cat"){
                cat.setType("cat");
            } else {
                cat.setType("path");
            }

            if (dest.isCheese()) {
                dest.setType("cat on cheese");
            } else if (dest.getType() == "cat") {
                dest.setType("double cat");
            } else if (dest.getType() == "double cat") {
                dest.setType("triple cat");
            } else {
                if (dest.isMouse())
                    Main.endGame(false);
                dest.setType("cat");
            }
        }
        return maze;
    }
}