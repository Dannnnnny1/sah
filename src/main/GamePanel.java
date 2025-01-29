package main;

import piece.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    public static final int WIDTH=1100;
    public static final int HEIGHT=800;
    final int FPS=60;
    Thread gameThread;
    Board board=new Board();

    //PIECES
    public static ArrayList<Piece> pieces=new ArrayList<>();
    public static ArrayList<Piece>simPieces=new ArrayList<>();


    //COLORS
    public static final int WHITE=0;
    public static final int BLACK=1;
    int currentColor=WHITE;

    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setPieces();
        copyPieces(pieces,simPieces);
    }
    private void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        //Board
        board.draw(g2);
        //Pieces
        for(Piece p:simPieces){
            p.draw(g2);
        }
    }
    public void setPieces(){
        //WHITE PIECES
        pieces.add(new Pawn(0,1,WHITE));
        pieces.add(new Pawn(1,1,WHITE));
        pieces.add(new Pawn(2,1,WHITE));
        pieces.add(new Pawn(3,1,WHITE));
        pieces.add(new Pawn(4,1,WHITE));
        pieces.add(new Pawn(5,1,WHITE));
        pieces.add(new Pawn(6,1,WHITE));
        pieces.add(new Pawn(7,1,WHITE));
        pieces.add(new Rook(0,0,WHITE));
        pieces.add(new Rook(7,0,WHITE));
        pieces.add(new King(4,0,WHITE));
        pieces.add(new Queen(3,0,WHITE));
        pieces.add(new Bishop(2,0,WHITE));
        pieces.add(new Bishop(5,0,WHITE));
        pieces.add(new Knight(1,0,WHITE));
        pieces.add(new Knight(6,0,WHITE));

        //BLACK PIECES
        pieces.add(new Pawn(0,6,BLACK));
        pieces.add(new Pawn(1,6,BLACK));
        pieces.add(new Pawn(2,6,BLACK));
        pieces.add(new Pawn(3,6,BLACK));
        pieces.add(new Pawn(4,6,BLACK));
        pieces.add(new Pawn(5,6,BLACK));
        pieces.add(new Pawn(6,6,BLACK));
        pieces.add(new Pawn(7,6,BLACK));
        pieces.add(new Rook(0,7,BLACK));
        pieces.add(new Rook(7,7,BLACK));
        pieces.add(new King(4,7,BLACK));
        pieces.add(new Queen(3,7,BLACK));
        pieces.add(new Bishop(2,7,BLACK));
        pieces.add(new Bishop(5,7,BLACK));
        pieces.add(new Knight(1,7,BLACK));
        pieces.add(new Knight(6,7,BLACK));


    }
    private void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target){
        target.clear();
        for(int i=0;i<source.size();i++){
            target.add(source.get(i));
        }
    }
    @Override
    public void run(){
        //GAME LOOP
        double interval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        while(true){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/interval;
            lastTime=currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
        }

    }
    public void launchGame(){
        gameThread=new Thread(this);
        gameThread.start();
    }
}
