package com.company;

/**
 * Created by Eli on 2017-02-17.
 */
public class BoardObjects {
    private boolean isVisible = false;
    private boolean isTraversable = false;
    private String type = "wall";
    int yCoodinate = 0;
    int xCoodinate = 0;

    public BoardObjects(boolean isVisible, String type) {
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
    public String getType() {
        String p = "";
        if(this.type == "wall"){
            p = "w";
        }
        else {
            p = "p";
        }
        return  p;
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
