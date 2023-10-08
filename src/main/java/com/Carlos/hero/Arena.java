package com.Carlos.hero;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TerminalPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TO DO IMPLEMENTAR NAO COLIDE COM AS WALLS
public class Arena{
    private  int width;
    private  int height;
    private  List <Wall> walls1;// Inicializa as walls na arena
    private List <Coin> coins;
    //this.walls = createWalls();

    Arena (int width, int height){
        this.width = width;
        this.height = height;
        walls1 = createWalls(width, height);
        coins = createCoins();
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
    public  boolean canHeroMove(Position p){
        for (Wall wall : walls1){
            if (p.equals(wall.getPosition())) {
                return false;
            }
        }
        return true;
    }


    public void draw(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.ANSI.RED);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');;
        for (Wall wall : walls1) //Desenhar cada uma das paredes
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
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

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return coins;
    }
}

