package com.company;

/**
 * Created by Eli on 2017-02-17.
 */
public class BoardObject {
    private boolean isVisible = false;
    private boolean isTraversable = false;
    private String type = "wall";
    int yCoodinate = 0;
    int xCoodinate = 0;

    public BoardObject(boolean isVisible, String type) {
        this.isVisible = isVisible;
        this.type = type;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void setTraversable(boolean traversable) {
        isTraversable = traversable;
    }

    public void setType(String type) {
        this.type = type;
    }
    //These need to be set up-------------
    public int getX() {
        return 1;
    }
    public int getY() {
        return 1;
    }
    public void setX(int x) {
        //asdasd
    }
    public void setY(int y) {
        //asdasd
    }
    //-------------------
    public String getTypeForTesting() { // used for testing
        String p = "";
        if(this.type == "wall"){
            p = "w";
        }
        else if (this.type == "cheese"){
            p = "c";
        }
        else if (this.type == "player"){
            p = "p";
        }
        else {
            p = "-";
        }
        return  p;
    }
    public String getType() { // used for testing
        return this.type;
    }

    public boolean isTraversable() {
        return isTraversable;
    }

    public boolean isMouse() {
        if(type == "mouse"){
            return true;
        }
        else {
            return false;
        }

    }
    public boolean isCat() {
        if (type == "cat") {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isPath() {
        if (type == "path") {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isCheese() {
        if (type == "cheese") {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isWall() {
        if (type == "wall") {
            return true;
        }
        else {
            return false;
        }
    }


}
