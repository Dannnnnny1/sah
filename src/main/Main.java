package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window=new JFrame("Joc de sah");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        //ADD GAME PANEL
        GamePanel gp=new GamePanel();
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.launchGame();

    }
}