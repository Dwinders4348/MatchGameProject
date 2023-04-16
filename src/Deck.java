import java.util.*;

public class Deck {
    
    //Constants-----------------------------

    public static final int CARDS_IN_DECK = 52;

    public static final int NUMBER_OF_SUITS = 4;

    //fields------------------------------------
    private Card[] cards = new Card[CARDS_IN_DECK];
    private int next;

   


    //Constructor----------------------------------------
   
    public Deck(){
        
         //Set cards array with cards

        int index = 0; 
        
        for(int i = 2; i < 15; i++) {
            cards[index] = new Card('c', i);
            index++;
        }
        for(int i = 2; i < 15; i++) {
            cards[index] = new Card('d', i);
            index++;
        }
        for(int i = 2; i < 15; i++) {
            cards[index] = new Card('h', i);
            index++;
        }
        for(int i = 2; i < 15; i++) {
            cards[index] = new Card('s', i);
            index++;
        }


        next = 0;

    }


    //methods-----------------------------------------------
    public int getNext(){
        return this.next;
    }

    public Card[] getCards(){
        return this.cards;
    }

    public void shuffle(){
        // for (i = n - 1; down to 1 do
        // swap a[i] with a random element among a[0],...,a[i]
        // (so if the chosen element is a[i], it stays put)

        for (int i = CARDS_IN_DECK - 1; i > 0; i--){
            Random rand = new Random();
            int num = rand.nextInt(i + 1); 
            Card temp = cards[i];
            cards[i] = cards[num];
            cards[num] = temp;

        }

  
    }

    public Card nextCard() throws IllegalStateException {
        if(next >= CARDS_IN_DECK) {
            throw new IllegalStateException("No more cards");
        }
        next++;
        return cards[next - 1];
    }
    
    public boolean equals(Object o){
        
        Deck d;

        if((o instanceof Deck)){
            d = (Deck)o;
        } else {
            return false;
        }


        if((!(Arrays.equals(d.cards, this.cards) && (this.next == d.next)))) {
            return false;
        }
       

        return true;
    }

    public String toString(){
        String deck = ""; 
        
        
        for (int i = 0; i < CARDS_IN_DECK; i++) {
        //   String add = cards[i].toString();
          deck += "card " + i + ": " + cards[i].toString() + "\n";

        }
        
        return deck;
    }



}


//testing testing