package com.Carlos.hero;

import com.googlecode.lanterna.graphics.TextGraphics; //Used to manipulate and draw text-based graphics on a terminal screen
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.SGR; //These SGR codes are used to set colors, styles (bold, underline, etc.), and other text attributes.


public class Hero {

    private int tempx;
    private int tempy;

    Hero(int x, int y){
        this.tempx = x;
        this.tempy = y;
    }
    Position position = new Position(tempx, tempy);
    public Position moveUp(){
        return new Position(position.getX(),position.getY() - 1); // Movimento para cima
    }
    public Position moveDown(){
        return new Position(position.getX(),position.getY() + 1); // Movimento para baixo

    }
    public Position moveLeft(){
        return new Position(position.getX() - 1, position.getY()); // " "
    }
    public Position moveRight(){
        return new Position(position.getX() + 1, position.getY()); // " "
    }
    public void setPosition(Position p){ // Premitir que haja essa actual mudança de posição
        position.setX(p.getX());
        position.setY(p.getY());
    }

    public void drawHero(TextGraphics graphics) { // Desenhar o Hero
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(position.getX(), position.getY()), "H");

    }
}



