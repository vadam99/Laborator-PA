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
class Laborator7{
    

  public static void main(String args[])
{
       int k=8;      
       ArrayList<Token> tokens=new ArrayList<>();
       
       Token token1=new Token(2);
       Token token2=new Token(3);
       Token token3=new Token(5);
       Token token4=new Token(10);
       Token token5=new Token(16);
       Token token6=new Token(1);
       Token token7=new Token(15);
       Token token8=new Token(6);
       Token token9=new Token(9);
       Token token10=new Token(12);
       
       tokens.add(token1);
       tokens.add(token2);
       tokens.add(token3);
       tokens.add(token4);
       tokens.add(token5);
       tokens.add(token6);
       tokens.add(token7);
       tokens.add(token8);
       tokens.add(token9);
       tokens.add(token10);

       Game game = new Game(k);
       
       Player player1= new Player("Adam", game);
       Player player2= new Player("Jucator1", game);
       Player player3= new Player("Costel", game);
       
       game.addPlayer(player1);
       game.addPlayer(player2);
       game.addPlayer(player3);
       game.setBoard(new Board(tokens));
       game.start();
}}