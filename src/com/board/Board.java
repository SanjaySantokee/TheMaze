package com.board;

import com.map.Map;
import com.maze.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Map map;
    private Player player;
    String message = "";
    private boolean win = false;

    public Board() {
        map = new Map();
        player = new Player();
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (map.getMap(player.getTileX(), player.getTileY()).equals("f")) {
            message = "winner";
            win = true;
        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        if (!win) {

            for (int y = 0; y < 15; y++) {
                for (int x = 0; x < 20; x++) {

                    if (map.getMap(x, y).equals("w")) {
                        g2.setPaint(Color.RED);
                        Rectangle rec = new Rectangle(x * 32, y * 32, 32, 32);
                        g2.fill(rec);
                    }

                    if (map.getMap(x, y).equals("p")) {
                        g2.setPaint(Color.WHITE);
                        Rectangle rec = new Rectangle(x * 32, y * 32, 32, 32);
                        g2.fill(rec);
                    }

                    if (map.getMap(x, y).equals("b")) {
                        g2.setPaint(Color.BLUE);
                        Rectangle rec = new Rectangle(x * 32, y * 32, 32, 32);
                        g2.fill(rec);
                    }

                    if (map.getMap(x, y).equals("f")) {
                        g2.setPaint(Color.GREEN);
                        Rectangle rec = new Rectangle(x * 32, y * 32, 32, 32);
                        g2.fill(rec);
                    }
                }
            }

            //Player
            g2.setPaint(Color.BLACK);
            Rectangle rec = new Rectangle(player.getTileX() * 32, player.getTileY() * 32, 32, 32);
            g2.fill(rec);

        }

        //Winner
        if (win){
            g2.drawString(message, 870, 200);
        }


    }

    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {
                if (!map.getMap(player.getTileX(), player.getTileY() - 1).equals("w")) {
                    player.move(0, -1);
                }

            }

            if (key == KeyEvent.VK_DOWN) {
                if (!map.getMap(player.getTileX(), player.getTileY() + 1).equals("w")) {
                    player.move(0, 1);
                }
            }

            if (key == KeyEvent.VK_LEFT) {
                if (!map.getMap(player.getTileX() - 1, player.getTileY()).equals("w")) {
                    player.move(-1, 0);
                }
            }

            if (key == KeyEvent.VK_RIGHT) {
                if (!map.getMap(player.getTileX() + 1, player.getTileY()).equals("w")) {
                    player.move(1, 0);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }
    }

}
