package com.Carlos.hero;

import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.io.IOException;
import java.security.Key;

public class Game {

    private Screen screen;
    private int x = 10;
    private int y = 10;
    Game(){
        try{
            Terminal terminal = new
                    DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void draw() throws IOException{

        try{
                screen.clear();
                screen.setCharacter(x, y, TextCharacter.fromCharacter('H')
                        [0]);
                screen.refresh();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void run() throws IOException{
        while(true) {
            draw();
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
                x--;
            }
            case ArrowRight -> {
                x++;
            }
            case ArrowUp -> {
                y--;
            }
            case ArrowDown -> {
                y++;
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
}
