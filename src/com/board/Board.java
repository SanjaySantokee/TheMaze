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
import java.util.TimerTask;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Map map;
    private Player player;
    String message = "";
    private boolean win = false;
    private boolean lose = false;
    private int level = 1;
    private int secondsLeft = 15;
    private boolean isRunning = false;
    private int x = 800;
    private Thread gameThread;
    private Graphics2D g2;

    public Board() {
        map = new Map(this);
        player = new Player(this);
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
        startCountdown();

        Graphics g = this.getGraphics();
        g2 = (Graphics2D) g;

//        startGame();
    }

    private java.util.Timer countdown = new java.util.Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsLeft--;
            if (secondsLeft < 0) {
                lose = true;
                stopCountDown();
            }
            System.out.println("Seconds Left: " + secondsLeft);
        }
    };

    public void startCountdown() {
        countdown.scheduleAtFixedRate(task, 2000, 1000);
    }

    public void stopCountDown() {
        countdown.cancel();
    }

    public void actionPerformed(ActionEvent e) {
        if (map.getMap(player.getTileX(), player.getTileY()).equals("f")) {
            level++;

            if (level == 2) {
                player.setTileX(27);
                player.setTileY(15);

                secondsLeft = 25;
            }

            if (level == 3) {
                player.setTileX(35);
                player.setTileY(1);

                secondsLeft = 35;
            }

            if (level > 3) {
                message = "winner";
                win = true;
            }

        }
        repaint();
    }
//
//    public void paint(Graphics g){
//        super.paint(g);
//    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        if (!win && !lose) {

            map.paintMap(g);

            player.paintPlayer(g);

            Font f = new Font("Consolas", Font.BOLD, 60);
            g2.setFont(f);
            g2.setColor(new Color(49, 46, 52));
            g2.drawString("THE MѦZE", 780, 100);

            f = new Font("Calibri", Font.BOLD, 40);
            g2.setFont(f);
            g2.drawString("LEVEL " + level, 850, 200);

            f = new Font("Calibri", Font.BOLD, 30);
            g2.setFont(f);
            g2.drawString("Time Left:  00:00:" + secondsLeft, 800, 300);

        }

        //Winner
        if (win) {
            g2.drawString(message, 870, 200);
        }

        if (lose) {
            g2.drawString("You Lose", 870, 200);
        }


    }

//    public void run() {
//        try {
//            isRunning = true;
//            while (isRunning) {
//                gameUpdate();
//                gameRender();
//                Thread.sleep(100);    // increase value of sleep time to slow down ball
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void gameUpdate() {
//        if (!isVisible ()) return;
//        erase();
//        this.x += 20;
//    }
//
//    public void gameRender() {
//        player.paintPlayer();
////        g2.setColor(Color.black);
////        Ellipse2D.Double circle = new Ellipse2D.Double(this.x, 20, 150, 150);
////        g2.draw(circle);
//    }
//
//    public void erase() {
//        player.erase();
////        g2.setColor(Color.white);
////        g2.fill(new Ellipse2D.Double(this.x, 20, 150, 150));
//    }
//
//    public void startGame() {                // initialise and start the game thread
//
//        if (gameThread == null) {
//            isRunning = true;
//            gameThread = new Thread(this);
//            gameThread.start();
//        }
//    }

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
