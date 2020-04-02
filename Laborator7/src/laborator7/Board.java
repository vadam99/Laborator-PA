/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator7;
import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author vadam
 */
public class Board {
    public ArrayList<Token> tokens;

    public Board(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }
    public void adaugaTokeni(Token token)
    {
        tokens.add(token);
    }
    public void scoateTokeni(Token token)
    {
        tokens.remove(token);
    }
}
    