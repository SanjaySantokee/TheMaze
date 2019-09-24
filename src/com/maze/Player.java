package com.maze;

public class Player {

    private int tileX, tileY;

    //level 1 x=1, y=1
    //level 2 x=27, y =15
    //level 3 x=35 y=1

    public Player(){
        this.tileX = 1;
        this.tileY = 1;
    }

    public void move(int dx, int dy){
        this.tileX += dx;
        this.tileY += dy;

        System.out.println("X = " + tileX + " and Y = " + tileY);
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }
}
