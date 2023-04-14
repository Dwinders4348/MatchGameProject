import java.awt.*;
public class Card {

    //fields-------------

    public static final char CLUBS = 'c';

    public static final char DIAMONDS = 'd';

    public static final char HEARTS = 'h';

    public static final char SPADES = 's';

    public static final int LOWEST_VALUE = 2;

    public static final int HIGHEST_VALUE = 14;

    char suit;
    int value;
    Color color;
    boolean hasBeenFound;




    
    //class constructor----------------------

    public Card(char suit, int value){
        this.suit = suit;
        this.value = value;

        if(!(suit == 'c' || suit == 'h' || suit == 's' || suit == 'd')){
            throw IllegalArgumentException("Invalid Suit");
        } else if (value > 14 || value < 2) {
            throw IllegalArgumentException("Invalid Value");
        }

    } 

   
   //methods--------------------------
   
    public char getSuit(){
        return this.suit;
        
    }

    public int getValue(){
        return this.value;
    }

    public Color getColor(){
        Color color = Color.YELLOW;

        if(this.suit == 'c' || this.suit == 's'){
            color = Color.BLACK;
        }
        if(this.suit == 'h' || this.suit == 'd'){
            color = Color.RED;
        }

        return color;
    }

    public boolean hasBeenFound(){
        return  this.hasBeenFound;
    }

    public void setHasBeenFound(boolean hasBeenFound){
        
    }

    public boolean hasSameValue(Card other){
        if (this.value == other.value) {
            this.hasSameValue = true;
        } else {
            this.hasSameValue = false;
        }

        return this.hasSameValue;
    }

    public boolean hasSameValueAndColor(Card other){
        if (this.color.equals(other.color) && this.hasSameValue){
            hasSameValueAndColor = true;
        }
    }

    public boolean equals(Object o) {

    }

    public String toString(){

    }

}
