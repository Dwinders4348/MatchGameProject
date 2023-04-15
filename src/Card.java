import java.awt.*;


public class Card {

    //fields----------------------------

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

    public Card(char suit, int value) throws IllegalArgumentException {
        this.suit = suit;
        this.value = value;
        this.color = getColor();

        if(!(suit == 'c' || suit == 'h' || suit == 's' || suit == 'd')){
            throw new IllegalArgumentException("Invalid suit");
        } else if (value > 14 || value < 2) {
            throw new IllegalArgumentException("Invalid value");
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
        this.hasBeenFound = hasBeenFound;
        
    }

    public boolean hasSameValue(Card other){
        boolean hasSameValue;

        if (this.value == other.value) {
            hasSameValue = true;
        } else {
            hasSameValue = false;
        }

        return hasSameValue;
    }

    public boolean hasSameValueAndColor(Card other){
        boolean hasSameValueAndColor;

        if (this.color.equals(other.color) && (this.value == other.value)) {
            hasSameValueAndColor = true;
        } else {
            hasSameValueAndColor = false;
        }
        return hasSameValueAndColor;
    }

    public boolean equals(Object o) {
        
        if(!(o instanceof Card)){
            return false;
        }

        Card c = (Card)o;
        if(!(c.suit == this.suit)){
            return false;
        }
        
        if(!(c.value == this.value)){
            return false;
        }
        
        return true;
    }

    public String toString(){
        
        String value = "" + this.value;
        String suit = "" + this.suit;

        String card =  suit + value;
        
        
        return card;
    }

}
