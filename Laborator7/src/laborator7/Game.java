/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author vadam
 */
public class Game {
    private final List<Player> players = new ArrayList<>();
    private Board board;
    private Player player;
    private int k;
    private int n;
    public boolean gameOver=false;

    public Game(int k) {
        this.k = k;
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
        n=board.tokens.size();
    }
    
        //Functie realizata cu ajutorul https://www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/amp/
    private int verificareProgresie(ArrayList<Token> A) 
{ 
    int ans = 2; 
        int nn = A.size(); 
    if (nn <= 2) 
        return nn; 
    int []llap = new int[nn]; 
    for(int i = 0; i < nn; i++) 
        llap[i] = 2;
    Collections.sort(A); //sortam crescator folosind compareTo() din clasa Token
    for (int j = nn - 2; j >= 0; j--) 
    { 
        int i = j - 1; 
        int l = j + 1; 
        while (i >= 0 && l < nn) 
        { 
            if (A.get(i).getNumber() + A.get(l).getNumber() == 2 * A.get(j).getNumber()) 
            { 
                llap[j] = Math.max(llap[l] + 1, llap[j]); 
                ans = Math.max(ans, llap[j]); 
                i -= 1;
                l += 1; 
            } 
            else if (A.get(i).getNumber() + A.get(l).getNumber() < 2 * A.get(j).getNumber()) 
                l += 1; 
            else
                i -= 1; 
        } 
    } 
    return ans; 
}    
      public synchronized void extrageTokeni()
    {
         if(board.tokens.size()<=0)
         {
             gameOver=true;
             player.setPoints(verificareProgresie(board.tokens));
             System.out.println(player.getPoints());
         }
         else
             if(verificareProgresie(board.tokens)>=k)
             {
                 gameOver=true;
                 player.setPoints(n); //testat pt k=4 in main imi da eroare aici. orice pun imi da aceeasi eroare.
                 //chiar si daca incerc sa afisez punctele playerilor tot imi da eroare.
             }
         else {
         Token randomItem =board.tokens.get(new Random().nextInt(board.tokens.size()));
         board.scoateTokeni(randomItem);
         player.tokens.add(randomItem);//eroare pentru k=8 in main (si probabil si alte valori).
         }
    }
    /*
    public synchronized void extrageTokeni(){
    if(board.tokens.size() > 0 || verificareProgresie(board.tokens) < k)
         {
         Token randomItem =board.tokens.get(new Random().nextInt(board.tokens.size()));
         board.scoateTokeni(randomItem);
         player.tokens.add(randomItem);
         }
         else if(verificareProgresie(board.tokens)==k) //daca cineva face progresie aritmetica completa, primeste toate punctele.
         {
             gameOver=true;
             player.setPoints(k);
         }
         else
         { 
           player.setPoints(verificareProgresie(board.tokens)); //punctele jucatorilor
           gameOver=true;
         } }*/
         
    public void start() {
        for( Player p : players ) {
            new Thread(p).start();
        }
    }   
}
