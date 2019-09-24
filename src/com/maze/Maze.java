package com.maze;

import com.board.Board;

import javax.swing.*;

public class Maze {

    public Maze(){
        JFrame frame = new JFrame();
        frame.setSize(1100, 512);
        frame.setResizable(true);
        frame.setTitle("The Maze");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Board());
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Maze();
    }

}
