package com.Carlos.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Element {

    Position getPosition(){
        return position;
    }
    Wall(int x, int y){
        super(x,y);
    }
    void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),"+");
    }

}
//Desenhar Walls
//Metodo de colisao do hero com Walls