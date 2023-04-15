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
        for (int i = 0; i < 13; i++) {
            cards[i] = new Card('c', i+2);
        }
        for (int j = 13; j > 12 && j < 24; j++) {
            cards[j] = new Card('d', j + 2);
        }
        for (int k = 24; k < 36; k++){
            cards[k] = new Card('h', k + 2);
        }
        for (int l = 36; l < 52; l++ ){
            cards[l] = new Card('s', l+2);
        }

        next = 0;

    }


    //methods-----------------------------------------------
    public int getNext(){
        return 0;
    }

    public Card[] getCards(){
        return this.cards;
    }

    public void shuffle(){
        // for (i = n - 1; down to 1 do
        // swap a[i] with a random element among a[0],...,a[i]
        // (so if the chosen element is a[i], it stays put)
  
    }

    public Card nextCard(){
        return cards[next];
    }
    
    public boolean equals(Object o){
        return true;
    }

    public String toString(){
        return "";
    }



}


//testing testing