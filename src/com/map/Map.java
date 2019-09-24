package com.map;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Map {

    private Scanner scanner;
    private String[] Map = new String[20];
    private Graphics g;

    public Map() {
        this.openFile();
//        System.out.println("going to read now");
        this.readFile();
        this.closeFile();
    }

    public void openFile() {
        try {
            scanner = new Scanner(new File("assets/maps/map1.txt"));
//            System.out.println("opened");
        } catch (Exception e){
            System.out.println("Error Loading Map");
        }
    }

    public void readFile() {

        while(scanner.hasNext()){
//            System.out.println("beginning read");
            for (int i =0; i < 15; i++){
                Map[i] = scanner.next();
//                System.out.println("\n " + (i+1) + ". " + scanner.next());
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

}
