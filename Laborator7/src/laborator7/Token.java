/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator7;

/**
 *
 * @author vadam
 */
public class Token implements Comparable {
    private int number;
    public boolean blank=false;
    public int points;

    public void setBlank(boolean blank) {
        this.blank = blank;
    }  
    public Token(int number) {
        this.number = number;
    }

    public void setNumber(int number) { //blank token
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }    


    @Override
    public int compareTo(Object o) {
        int comparatie=((Token)o).getNumber();
        return this.number-comparatie;
    }
}
