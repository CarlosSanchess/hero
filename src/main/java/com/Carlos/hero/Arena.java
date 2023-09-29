package com.Carlos.hero;

public class Arena {
    private static int width;
    private static int height;

    Arena (int width, int height){
        Arena.width = width;
        Arena.height = height;
    }
    public static boolean canHeroMove(Position p){
        return p.getX() < width && p.getY() < height;
    }

}
