import java.awt.*;

/**
 * @author Damion Winders
 * represents a single playing card
 * in the Match game
 */
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

    /**
     * 
     * @param suit
     * @param value
     * @throws IllegalArgumentException
     * 
     */
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
   
    /**
     * 
     * @return character that represents
     * a card's suit
     */
    public char getSuit(){
        return this.suit;
        
    }

    /**
     * 
     * @return an integer that represents
     * a card's value
     */
    public int getValue(){
        return this.value;
    }

    /**
     * 
     * @return a color that is determined
     * by the suit of the card
     */
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

    /**
     * 
     * @return a boolean that represents whether
     * a card has been found
     */
    public boolean hasBeenFound(){
        return  this.hasBeenFound;
    }

    /**
     * 
     * @param hasBeenFound
     * sets the value of hasBeenFound boolean
     */
    public void setHasBeenFound(boolean hasBeenFound){
        this.hasBeenFound = hasBeenFound;
        
    }

    /**
     * 
     * @param other
     * @return boolean that represents whether
     * two cards have the same value
     */
    public boolean hasSameValue(Card other){
        boolean hasSameValue;

        if (this.value == other.value) {
            hasSameValue = true;
        } else {
            hasSameValue = false;
        }

        return hasSameValue;
    }

    /**
     * 
     * @param other
     * @return boolean that represents whether
     * two cards have the same value and color 
     */
    public boolean hasSameValueAndColor(Card other){
        boolean hasSameValueAndColor;

        if (this.color.equals(other.color) && (this.value == other.value)) {
            hasSameValueAndColor = true;
        } else {
            hasSameValueAndColor = false;
        }
        return hasSameValueAndColor;
    }

    /**
     * @return boolean that represents whether
     * two cards are equal to each other
     */
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

    /**
     * @returns string that represents
     * the card's name
     */
    public String toString(){
        
        String value = "" + this.value;
        String suit = "" + this.suit;

        String card =  suit + value;
        
        
        return card;
    }

}
