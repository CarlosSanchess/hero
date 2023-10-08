package com.Carlos.hero;

import com.googlecode.lanterna.graphics.TextGraphics; //Used to manipulate and draw text-based graphics on a terminal screen
public abstract class Element {

    protected Position position; // All the subclasses will have a Position position
   Element(int x, int y){
       position = new Position(x,y);
   }

    abstract void draw(TextGraphics graphics);
}
