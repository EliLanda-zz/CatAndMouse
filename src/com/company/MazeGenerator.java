package com.company;

import java.util.List;
import java.util.Random;

/**
 * Created by Eli on 2017-02-17.
 */
public class MazeGenerator {
   /* Maze Builder
	1. Creact a 2 dimentional array of BoardObjects
	2. set all objects in the array to be walls and invisible
	3. Set the BoardObjects in the [0][Y], [maxX][Y], [X][0], and [X][maxY] (xMax and yMax, are the last indexes) indexes to be visible. this will make the outer boarder of the maze visible
	4. Select a  random starting point on the array. Use odd numbers for row and column. Set the BoardObject at this index to be path instead of wall
	5. use x and y variables to keep track of your position
	6. randomly pick a direction to go (either up, down, left, or right) - Before finalizing direction,
    check if two cells into that direction is outside of the bounds of the maze (needs a valid array index) and make sure that the path in that direction is a wall.
            if those conditions are not met, keep re picking directions. if it finds that it is at a dead end, we need to backtrack (more later).
            7. once the direction is picked, always move 2 cells in that direction and set those cells that you traversed to be paths and not walls
	8. If a dead end is found, backtrack along the path until a new direction that meets the requirements layed out in step 66 is found. if none are found the maze is complete
	9. traverse the 2dimensional array that this maze is stored in looking for BoardObjects tagged as walls. pick a random number between 1 and 10. if the number is less than a 3, re tagg this BoardObject to be a path.
	10. Set [1][1] to be tagged as player
	11. traverse the  dimensional array that this maze is stored in and create an array of all the indexes containing BoardObjects tagged as path. randomly select from these indexes 1 index.
	12. set the BoardObject at that index to be tagged as cheese
*/
    List<List<BoardObjects>> generateMazeObjects (){
        //1. Creact a 2 dimentional array of BoardObjects
        List<List<BoardObjects>> boardMatrix = null;
        List<BoardObjects> row = null;
        int width = 10;
        int height = 10;
        //2. set all objects in the array to be walls and invisible
        for(int i = 0; i < width; i++){
            row.add(i, new BoardObjects(false,"wall"));
        }
        for(int k = 0; k < height; k++){
            boardMatrix.add(k, row);
        }


        //3. Set the BoardObjects in the [0][Y], [maxX][Y], [X][0], and [X][maxY] (xMax and yMax, are the last indexes) indexes to be visible. this will make the outer boarder of the maze visible
        for(int k = 0; k < height; k++){
           boardMatrix.get(0).get(k).setVisible(true);
           boardMatrix.get(height-1).get(k).setVisible(true);
           boardMatrix.get(k).get(0).setVisible(true);
           boardMatrix.get(k).get(width).setVisible(true);
        }

        //4. Select a  random starting point on the array. Use odd numbers for row and column. Set the BoardObject at this index to be path instead of wall
        Random random = new Random();
        int xRand = random.nextInt(width-1);
        while (xRand % 2 == 0){
            xRand = random.nextInt(width-1);
        }
        int yRand = random.nextInt(height-1);
        while (yRand % 2 == 0){
            yRand = random.nextInt(height-1);
        }
        boardMatrix.get(yRand).get(xRand).setVisible(true);
        boardMatrix.get(yRand).get(xRand).setTraversable(true);
        boardMatrix.get(yRand).get(xRand).setType("Path");

        //5. use x and y variables to keep track of your position
        int currentX = xRand;
        int currentY = yRand;

        //6. randomly pick a direction to go (either up, down, left, or right) - Before finalizing direction,
        //check if two cells into that direction is outside of the bounds of the maze (needs a valid array index) and make sure that the path in that direction is a wall.
        //if those conditions are not met, keep re picking directions. if it finds that it is at a dead end, we need to backtrack (more later).
        int dir = 0;
        boolean isValidMove = false;
        while (!isValidMove) {
            dir = random.nextInt(3);
            //checks 2 indexes up
            if (dir == 0) {
                if (currentY + 2 < height && boardMatrix.get(currentY + 2).get(currentX).isWall()) {
                    isValidMove = true;
                } else {
                    isValidMove = false;
                }
            }
            //checks 2 indexes down
            if (dir == 1) {
                if (currentY - 2 > 0 && boardMatrix.get(currentY - 2).get(currentX).isWall()) {
                    isValidMove = true;
                } else {
                    isValidMove = false;
                }
            }
            //checks 2 indexes left
            if (dir == 2) {
                if (currentX - 2 > 0 && boardMatrix.get(currentY).get(currentX - 2).isWall()) {
                    isValidMove = true;
                } else {
                    isValidMove = false;
                }
            }
            //checks 2 indexes right
            if (dir == 3) {
                if (currentX + 2 < width && boardMatrix.get(currentY).get(currentX + 2).isWall()) {
                    isValidMove = true;
                } else {
                    isValidMove = false;
                }
            }
        }

        //7. once the direction is picked, always move 2 cells in that direction and set those cells that you traversed to be paths and not walls
        //sets next 2 indexes up
        if (dir == 0) {
            boardMatrix.get(currentY+1).get(currentX).setType("path");
            boardMatrix.get(currentY+2).get(currentX).setType("path");
            currentY += 2;
        }
        //sets next 2 indexes down
        if (dir == 1) {
            boardMatrix.get(currentY-1).get(currentX).setType("path");
            boardMatrix.get(currentY-2).get(currentX).setType("path");
            currentY -= 2;
        }
        //sets next 2 indexes left
        if (dir == 2) {
            boardMatrix.get(currentY).get(currentX-1).setType("path");
            boardMatrix.get(currentY).get(currentX-2).setType("path");
            currentX -= 2;
        }
        //sets next 2 indexes right
        if (dir == 3) {
            boardMatrix.get(currentY).get(currentX+1).setType("path");
            boardMatrix.get(currentY).get(currentX+2).setType("path");
            currentX += 2;
        }

        //8. If a dead end is found, backtrack along the path until a new direction that meets the requirements layed out in step 66 is found. if none are found the maze is complete

        //9. traverse the 2dimensional array that this maze is stored in looking for BoardObjects tagged as walls. pick a random number between 1 and 10. if the number is less than a 3, re tagg this BoardObject to be a path.

        return boardMatrix;
    }
    void randomDir (){

    }
}
