public class MatchGame {

    public static final int ROWS = 4; 

    public static final int COLS = 13;

    //instance fields----------------------------------------

    private Deck deck;

    private Grid grid;

    private int numberOfCorrectGuesses;
    
    private int numberOfGuesses;

    private boolean isEasy;

    //Constructor-----------------------------------------
    public MatchGame(boolean isTesting, boolean isEasy){

        this.isEasy = isEasy;
        this.deck = new Deck();
        
        if(!isTesting){
            deck.shuffle();
        }

        this.grid = new Grid(ROWS, COLS);

        for(int i = 0; i < ROWS; i++){
            
            for(int j = 0; j < COLS; j++){

                grid.cards[i][j] = deck.nextCard();
            }
        }

    }



     //Methods---------------------------------------
     public int getNumberOfGuesses() {

        return this.numberOfGuesses;
    }

    public int getNumberOfCorrectGuesses(){
        
        return this.numberOfCorrectGuesses;
    }

    public double getGuessAverage(){
        if (numberOfCorrectGuesses == 0){
            return 0; 
        } else {
            return (double)(numberOfCorrectGuesses)/(numberOfGuesses);
        }

        
    }

    public String getCardName(int row, int col){
        if(row < 0 || row >= ROWS){
            throw new IllegalArgumentException("Invalid row");
        }
        if(col < 0 || col >= COLS){
            throw new IllegalArgumentException("Invalid col");
        }
        
        String cardName = "";

        Card card = this.grid.getCard(row, col);

        cardName = card.toString();
        

        return cardName;
    }

    public boolean hasBeenFound(int row, int col){
        if(row >= ROWS || row < 0){
            throw new IllegalArgumentException("Invalid row");
        }
        if(col < 0 || col >= COLS){
            throw new IllegalArgumentException("Invalid col");
        }
      
        if(this.grid.getCard(row, col).hasBeenFound()){
            return true;
        }

        return false;
    }

    public boolean isMatch(int card1Row, int card1Col, int card2Row, int card2Col){
        
        if(card1Row < 0 || card1Row >= ROWS){
            throw new IllegalArgumentException("Invalid card1Row");
        }
        if(card1Col < 0 || card1Col >= COLS){
            throw new IllegalArgumentException("Invalid card1Col");
        }
        if(card2Row < 0 || card2Row >= ROWS){
            throw new IllegalArgumentException("Invalid card2Row");
        }
        if(card2Col < 0 || card2Col >= COLS){
            throw new IllegalArgumentException("Invalid card2Col");
        }

        numberOfGuesses++;

       
        if(!grid.getCard(card1Row, card1Col).hasBeenFound() && !grid.getCard(card2Row, card2Col).hasBeenFound()) {

            if(!isEasy){
                if(grid.getCard(card1Row, card1Col).hasSameValueAndColor(grid.getCard(card2Row, card2Col))){
                    Card card1 = grid.getCard(card1Row, card1Col);
                    card1.hasBeenFound = true;
                    Card card2 = grid.getCard(card2Row, card2Col);
                    card2.hasBeenFound = true;
                    numberOfCorrectGuesses++;
                    return true;
                }
            }

            if(isEasy && grid.getCard(card1Row, card1Col).hasSameValue(grid.getCard(card2Row, card2Col))) {
                grid.getCard(card1Row, card1Col).hasBeenFound = true;
                grid.getCard(card2Row, card2Col).hasBeenFound = true;
                numberOfCorrectGuesses++;
                return true;
            }
            
         }
        
         return false;
         

    }

    public Deck getDeck(){
        return deck;
    }

    public Grid getGrid(){
        return grid;
    }
 

    
    
}

