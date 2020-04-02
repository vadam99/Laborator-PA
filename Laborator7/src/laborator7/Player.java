/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator7;

import java.util.ArrayList;

/**
 *
 * @author vadam
 */
public class Player implements Runnable {
    private final String name;
    private final Game game;
    private int points;
    public ArrayList<Token> tokens;
    public Player(String name, Game game) {
        this.name = name;
        this.game= game;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public String getName() {
        return name;
    }     
    @Override
    public void run() {
        while(!game.gameOver)
            game.extrageTokeni();
    }
}