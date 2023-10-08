package com.Carlos.hero;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.io.IOException;
import java.util.List;


public class Game {

    private Screen screen;
    private TextGraphics graphics;
    private int x = 10;
    private int y = 10;

    Hero hero = new Hero(x,y);
    Arena arena = new Arena(30,15);
    Coin coin = new Coin(0,0);


    Game() {
        try {
            Terminal terminal = new
                    DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() throws IOException{
        graphics = screen.newTextGraphics(); // Por aqui a atribuição do Text grpahics, para evitar que a screen seja NULL
        while(true) {
            coin.draw(graphics);
            drawGame(graphics); //Escreve tudo no terminal relacionado com GUI
            KeyStroke key = screen.readInput(); //Recebe o input do user, da tecla clicada
            if (key.getKeyType() == KeyType.EOF) //Caso fechemos o terminal
            {
                break;
            }
            processKey(key); //Decide que tipo de movimento vai ser feito consoante a key pressionada
        }
    }

    private void processKey(KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowLeft -> {
                moveHero(hero.moveLeft());
            }
            case ArrowRight -> {
                moveHero(hero.moveRight());
            }
            case ArrowUp -> {
                moveHero(hero.moveUp());
            }
            case ArrowDown -> {
                moveHero(hero.moveDown());
            }
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') // Fecha o terminal no caso da tecla q
        {
            try {
                screen.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
  private void moveHero(Position p){
        if(arena.canHeroMove(p)) {
            hero.setPosition(p);
        }
    }
    private void drawGame(TextGraphics graphics){

        try{
            screen.clear();
            arena.draw(graphics); // Desenha Walls e Arena e Coins
            hero.draw(graphics);
            screen.refresh();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
