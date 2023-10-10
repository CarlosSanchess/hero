package com.Carlos.hero;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.terminal.swing.TerminalScrollController;

import java.io.IOException;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TO DO IMPLEMENTAR NAO COLIDE COM AS WALLS
public class Arena {
    private int width;
    private int height;
    private List<Wall> walls1;// Inicializa as walls na arena
    private List<Coin> coins;
    private List<Monster> monsters;
    Score score = new Score();

    //this.walls = createWalls();

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        walls1 = createWalls(width, height);
        coins = createCoins();
        monsters = createMonsters();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean canHeroMove(Position p) {
        for (Wall wall : walls1) {
            if (p.equals(wall.getPosition())) {
                return false;
            }
        }
        return true;
    }


    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.ANSI.RED);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (Wall wall : walls1) //Desenhar cada uma das paredes
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster: monsters)
            monster.draw(graphics);
        score.draw(graphics);
    }

    private List<Wall> createWalls(int width, int height) {
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

        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(width - 2) + 1;
            int y = random.nextInt(height - 2) + 1;
            if (overLapCoin(coins, x, y)) {
                while (overLapCoin(coins, x, y) != false) {
                    x = random.nextInt(width - 2) + 1;
                    y = random.nextInt(height - 2) + 1;
                }
            }
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        }
        return coins;
    }

    private  Boolean overLapCoin(List<Coin> coins, int x, int y) { //Usada na função createCoins, como criar um template que da para usar para MOnsters and Coins

        for (Coin coin : coins) {
            if (Math.abs(coin.position.getX() - x) <= 1 && Math.abs(coin.position.getY() - y) <= 1) {  /// Implementar com a função equal da classe position
                return true;
            }
        }
        return false;
    }

    private Coin getObj(List<Coin> coins, Position p) {
        for (Coin coin : coins) {
            if (p.equals(coin.position)) {  /// Implementar com a função equal da classe position
                return coin;
            }
        }
        return null;
    }

    public void retrieveCoins(Position p) {
        if (getObj(coins, p) != null) {
            coins.remove(getObj(coins, p));
            score.setScore(score.getScore() + 1);
        }
        isCoinsEmpty();
    }

    private void isCoinsEmpty() {
        if (coins.isEmpty()) {
            coins = createCoins();
        }
    }

    private  Boolean overLapMonster(List<Monster> monsters, int x, int y) { //Usada na função createCoins, como criar um template que da para usar para MOnsters and Coins

        for (Monster monster : monsters) {
            if (Math.abs(monster.position.getX() - x) <= 1 && Math.abs(monster.position.getY() - y) <= 1) {  /// Implementar com a função equal da classe position
                return true;
            }
        }
        return false;
    }

    private List<Monster> createMonsters() //Cria  monstros em posições em que não esteja sobrepostos com outros monstros.
    {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int x = random.nextInt(width - 2) + 1;
            int y = random.nextInt(height - 2) + 1;
            if (overLapMonster(monsters, x, y) || (x == 10 && y == 10)) {
                while (overLapMonster(monsters, x, y) != false) {
                    x = random.nextInt(width - 2) + 1;
                    y = random.nextInt(height - 2) + 1;
                }
            }
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        }
        return monsters;

    }
    Position move(Position p){ //Da return na posição que o monster se vai mexer quando há um movimento do hero
        Random random = new Random();

        if(random.nextBoolean()){
            //Movimento X
            if(random.nextBoolean() && canHeroMove(new Position(p.getX() + 1, p.getY())))
                p.setX(p.getX() + 1);                                       //TODO DAR FIX NESTA FUNCAO
            else if (canHeroMove(new Position(p.getX() - 1, p.getY()))) {
                p.setX(p.getX() - 1);
            }
        }else{
            //Movimento Y
            if(random.nextBoolean() && canHeroMove(new Position(p.getX(), p.getY() + 1)))
                p.setY(p.getY() + 1);
            else if(canHeroMove(new Position(p.getX(), p.getY() - 1)))
                p.setY(p.getY() - 1);
        }
        return p;
    }
    public List<Position> moveMonstersP() //Pega as posições para mover os Monsters
    {
        ArrayList<Position> posicoes= new ArrayList<>();
        for (Monster monster : monsters){
            posicoes.add(move(monster.position));
        }
        return posicoes;
    }
    public void verifyMonsterCollisions(Position p){
        for (Monster monster : monsters)
        {
            if(p.equals(monster)){

            }
        }
    }


}