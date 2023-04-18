/**
 * @author Damion Winders
 * Handles logic behind Match game
 */
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
   
    /**
     * Stores value of isEasy and 
     * shuffles the deck if necessary
     * creates a grid to distribute cards
     * @param isTesting
     * @param isEasy
     * 
     */
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
     
     
    /**
     * @return an integer that 
     * represents the number of 
     * guesses made by the user
     */
    public int getNumberOfGuesses() {

        return this.numberOfGuesses;
    }

    /**
     * @return an integer that represents the 
     * number of correct guesses made by the user
     */
    public int getNumberOfCorrectGuesses(){
        
        return this.numberOfCorrectGuesses;
    }

    /**
     * 
     * @return a double that represents the ratio of correct 
     * guesses to the number of total guesses
     */
    public double getGuessAverage(){
        if (numberOfCorrectGuesses == 0){
            return 0; 
        } else {
            return (double)(numberOfCorrectGuesses)/(numberOfGuesses);
        }

        
    }
    /**
     * 
     * @param row
     * @param col
     * @return a string that represents the name of the card
     * at the location given by the parameters row and col
     */
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

    /**
     * 
     * @param row
     * @param col
     * @return a boolean that represents whether 
     * the card has at the given row and col
     * has been found by the user 
     */
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

    /**
     * 
     * @param card1Row
     * @param card1Col
     * @param card2Row
     * @param card2Col
     * @return a boolean that represents whether
     * the two cards given by the coordinates in the
     * parameter match, based off of the game's definition
     */
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

    /**
     * 
     * @return the Deck object
     */
    public Deck getDeck(){
        return deck;
    }

    /**
     * 
     * @return the Grid object
     */
    public Grid getGrid(){
        return grid;
    }
 

    
    
}

