package com.Carlos.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;


import java.io.IOException;

public class Hero {

    private int tempx;
    private int tempy;

    Hero(int x, int y){
        this.tempx = x;
        this.tempy = y;
    }
    Position position = new Position(tempx, tempy);
    public Position moveUp(){
        return new Position(position.getX(),position.getY() - 1);
    }
    public Position moveDown(){
        return new Position(position.getX(),position.getY() + 1);

    }
    public Position moveLeft(){
        return new Position(position.getX() - 1, position.getY());
    }
    public Position moveRight(){
        return new Position(position.getX() + 1, position.getY());
    }
    public void setPosition(Position p){
        position.setX(p.getX());
        position.setY(p.getY());
    }

    public void draw(Screen screen) {
        try{
            screen.clear();
            screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('H')
                    [0]);
            screen.refresh();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}



