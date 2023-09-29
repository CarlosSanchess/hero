package com.Carlos.hero;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;


import java.io.IOException;


public class Game {

    private Screen screen;
    private int x = 10;
    private int y = 10;

    Hero hero = new Hero(x,y);

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
        while(true) {
            hero.draw(screen);
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.EOF)
            {
                break;
            }
            processKey(key);
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
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
        {
            try {
                screen.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
  public void moveHero(Position p){
            hero.setPosition(p);
    }
}
