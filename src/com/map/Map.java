package com.map;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Map {

    private Scanner scanner;
    private String[] Map = new String[24];
    private Graphics g;
    private Graphics2D g2;

    public Map(JPanel panel) {

        Graphics g = panel.getGraphics ();
        g2 = (Graphics2D) g;

        this.openFile();
        this.readFile();
        this.closeFile();
    }

    public void openFile() {
        try {
            scanner = new Scanner(new File("assets/maps/map2.txt"));
        } catch (Exception e){
            System.out.println("Error Loading Map");
        }
    }

    public void readFile() {

        while(scanner.hasNext()){
            for (int i =0; i < 24; i++){
                Map[i] = scanner.next();
            }
        }

    }

    public void closeFile() {
    }

    //uses this to see what shape to generate
    public String getMap(int x, int y){
        String index = Map[y].substring(x, x + 1);
//        System.out.println("Index is" + index);
        return index;
    }

    public void paintMap(Graphics g){

        Graphics2D g2 = (Graphics2D) g;

        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 37; x++) {

                if (getMap(x, y).equals("w")) {
                    g2.setColor(new Color(15, 94, 109));
                    Rectangle rec = new Rectangle(x * 20, y * 20, 20, 20);
                    g2.fill(rec);
                }

                if (getMap(x, y).equals("p")) {
                    g2.setColor(new Color(49, 46, 52));
                    Rectangle rec = new Rectangle(x * 20, y * 20, 20, 20);
                    g2.fill(rec);
                }

                if (getMap(x, y).equals("b")) {
                    g2.setPaint(Color.BLUE);
                    Rectangle rec = new Rectangle(x * 20, y * 20, 20, 20);
                    g2.fill(rec);
                }

                if (getMap(x, y).equals("f")) {
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
    }

}
