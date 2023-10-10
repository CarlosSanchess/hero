package com.Carlos.hero;
//TODO FIX NO FIM DO JOGO MUITO DIFICIL DE ACABAR

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        try{
            game.run();

        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
