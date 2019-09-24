package com.board;

import com.map.Map;
import com.maze.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Map map;
    private Player player;
    String message = "";
    private boolean win = false;
    private int level = 1;

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
            level++;

            if(level == 2){
                player.setTileX(27);
                player.setTileY(15);
            }

            if(level == 3){
                player.setTileX(35);
                player.setTileY(1);
            }

            if (level > 3){
                message = "winner";
                win = true;
            }

        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        if (!win) {

            for (int y = 0; y < 24; y++) {
                for (int x = 0; x < 37; x++) {

                    if (map.getMap(x, y).equals("w")) {
//                        g2.setPaint(Color.RED);
                        g2.setColor(new Color(15, 94, 109));
                        Rectangle rec = new Rectangle(x * 20, y * 20, 20, 20);
                        g2.fill(rec);
                    }

                    if (map.getMap(x, y).equals("p")) {
                        g2.setColor(new Color(49, 46, 52));
                        Rectangle rec = new Rectangle(x * 20, y * 20, 20, 20);
                        g2.fill(rec);
                    }

                    if (map.getMap(x, y).equals("b")) {
                        g2.setPaint(Color.BLUE);
                        Rectangle rec = new Rectangle(x * 20, y * 20, 20, 20);
                        g2.fill(rec);
                    }

                    if (map.getMap(x, y).equals("f")) {
//                        g2.setPaint(Color.GREEN);
                        GradientPaint gp4 = new GradientPaint(25, 25,
                                Color.blue, 25, 15, Color.black, true);
                        g2.setPaint(gp4);
                        Rectangle rec = new Rectangle(x * 20, y * 20, 20, 20);
                        g2.fill(rec);

                        Font f = new Font("Consolas", Font.BOLD, 12);
                        g2.setFont(f);
                        g2.setColor(Color.WHITE);
                        g2.drawString("END", x * 20, y * 20.5f);
                    }
                }
            }

            //Player
            GradientPaint gp4 = new GradientPaint(25, 25,
                    new Color(48, 0, 109), 15, 25,
                    new Color(109, 0, 255), true);
            g2.setPaint(gp4);

//            g2.setColor(new Color(252, 255, 242));
//            Rectangle rec = new Rectangle(player.getTileX() * 20, player.getTileY() * 20, 20, 20);
            Ellipse2D.Double avatar = new Ellipse2D.Double(player.getTileX() * 20, player.getTileY() * 20, 20, 20);
            g2.fill(avatar);

        }

        //Winner
        if (win) {
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
