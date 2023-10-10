package com.Carlos.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Score{

    private int score_atual;
    Score(){
         score_atual  = 0;
    }

    int getScore(){
        return score_atual;
    }
    void setScore(int s){
        score_atual = s;
    }
    void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.enableModifiers(SGR.BOLD);

        graphics.putString(new TerminalPosition(32,0), "Score:" + String.valueOf(score_atual));

    }

}
