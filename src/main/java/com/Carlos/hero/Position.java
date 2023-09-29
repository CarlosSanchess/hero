package com.Carlos.hero;


import com.googlecode.lanterna.terminal.swing.TerminalScrollController;

public class Position {
    private int x ;
    private int y;

    Position(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        try {
            this.x = x;
        }catch (NullPointerException n){
            n.printStackTrace();
        }
    }
    public void setY(int y){
        try {
            this.y = y;
        }catch (NullPointerException n){
            n.printStackTrace();
        }
    }

}
