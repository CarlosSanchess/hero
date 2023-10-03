package com.Carlos.hero;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TerminalPosition;

import java.util.ArrayList;
import java.util.List;

// TO DO IMPLEMENTAR NAO COLIDE COM AS WALLS
public class Arena {
    private static int width;
    private static int height;
    private static List <Wall> walls1; // Inicializa as walls na arena
    //this.walls = createWalls();

    Arena (int width, int height){
        Arena.width = width;
        Arena.height = height;
        walls1 = createWalls(width, height);
    }
    public static boolean canHeroMove(Position p){
        if(p.getY() < 0 || p.getX() < 0)
            return false;
        return p.getX() < width && p.getY() < height;
    }
    private boolean naoColide(Position p, List<Wall> walls){
        for (Wall wall : walls) {
            if (wall.get_x() == p.getX() && wall.get_y() == p.getY()) {
                return false;
            }
        }
        return true;
    }

    public static void drawArena(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.ANSI.RED);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');;

    }

    private List <Wall> createWalls(int width, int height){
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    public static List <Wall> get_Walls(){
        return walls1;
    }
}
