package com.maze;

public class Player {

    private int tileX, tileY;

    public Player(){
        this.tileX = 1;
        this.tileY = 1;
    }

    public void move(int dx, int dy){
        this.tileX += dx;
        this.tileY += dy;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }
}
