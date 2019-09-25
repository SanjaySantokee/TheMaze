package com.maze;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Player {

    private int tileX, tileY;
    private Graphics g;
    private Graphics2D g2;

    //level 1 x=1, y=1, 10s
    //level 2 x=27, y =15, 20s
    //level 3 x=35 y=1, 27s

    public Player(JPanel panel) {

        g = panel.getGraphics ();
        g2 = (Graphics2D) g;

        this.tileX = 1;
        this.tileY = 1;
    }

    public void move(int dx, int dy) {
        this.tileX += dx;
        this.tileY += dy;

//        System.out.println("X = " + tileX + " and Y = " + tileY);
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

    public void paintPlayer(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gp4 = new GradientPaint(25, 25,
                new Color(48, 0, 109), 15, 25,
                new Color(109, 0, 255), true);
        g2.setPaint(gp4);

        Ellipse2D.Double avatar = new Ellipse2D.Double(getTileX() * 20, getTileY() * 20, 20, 20);
        g2.fill(avatar);
    }

    public void erase(){
        g2.setPaint(Color.WHITE);

        Ellipse2D.Double avatar = new Ellipse2D.Double(getTileX() * 20, getTileY() * 20, 20, 20);
        g2.fill(avatar);
    }
}
