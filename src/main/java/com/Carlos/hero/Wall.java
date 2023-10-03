package com.Carlos.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private int x;
    private int y;

    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    Wall(int x, int y){
        this.x = x;
        this.y = y;
    }
    void drawWalls(TextGraphics graphics, Wall w){
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(w.x, w.y),"+");
    }

}
//Desenhar Walls
//Metodo de colisao do hero com Walls