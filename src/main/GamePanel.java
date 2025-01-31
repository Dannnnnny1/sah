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
    Mouse mouse=new Mouse();

    //PIECES
    public static ArrayList<Piece> pieces=new ArrayList<>();
    public static ArrayList<Piece>simPieces=new ArrayList<>();
    Piece activeP;


    //COLORS
    public static final int WHITE=0;
    public static final int BLACK=1;
    int currentColor=WHITE;

    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setPieces();
        copyPieces(pieces,simPieces);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }
    private void update(){
        //MOUSE BUTTON PRESSED
        if(mouse.pressed){
            if(activeP==null){
                for(Piece piece:simPieces){
                    if(piece.color==currentColor&&
                            piece.col==mouse.x/Board.SQUARE_SIZE
                            &&piece.row==mouse.y/Board.SQUARE_SIZE){
                        activeP=piece;
                    }
                }

            }
            else{
                simulate();
            }

        }



    }
    private void simulate(){
        activeP.x = mouse.x - Board.HALF_SQUARE_SIZE;
        activeP.y = mouse.y - Board.HALF_SQUARE_SIZE;
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
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,1,6));
        pieces.add(new Pawn(WHITE,2,6));
        pieces.add(new Pawn(WHITE,3,6));
        pieces.add(new Pawn(WHITE,4,6));
        pieces.add(new Pawn(WHITE,5,6));
        pieces.add(new Pawn(WHITE,6,6));
        pieces.add(new Pawn(WHITE,7,6));
        pieces.add(new Rook(WHITE,0,7));
        pieces.add(new Rook(WHITE,7,7));
        pieces.add(new Knight(WHITE,1,7));
        pieces.add(new Knight(WHITE,6,7));
        pieces.add(new Bishop(WHITE,2,7));
        pieces.add(new Bishop(WHITE,5,7));
        pieces.add(new Queen(WHITE,3,7));
        pieces.add(new King(WHITE,4,7));
        //BLACK PIECES
        pieces.add(new Pawn(BLACK,0,1));
        pieces.add(new Pawn(BLACK,1,1));
        pieces.add(new Pawn(BLACK,2,1));
        pieces.add(new Pawn(BLACK,3,1));
        pieces.add(new Pawn(BLACK,4,1));
        pieces.add(new Pawn(BLACK,5,1));
        pieces.add(new Pawn(BLACK,6,1));
        pieces.add(new Pawn(BLACK,7,1));
        pieces.add(new Rook(BLACK,0,0));
        pieces.add(new Rook(BLACK,7,0));
        pieces.add(new Knight(BLACK,1,0));
        pieces.add(new Knight(BLACK,6,0));
        pieces.add(new Bishop(BLACK,2,0));
        pieces.add(new Bishop(BLACK,5,0));
        pieces.add(new Queen(BLACK,3,0));
        pieces.add(new King(BLACK,4,0));

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
