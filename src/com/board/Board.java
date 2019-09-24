package com.board;

import com.map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Map map;

    public Board() {
        map = new Map();
        timer = new Timer(25, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

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

    }

}
