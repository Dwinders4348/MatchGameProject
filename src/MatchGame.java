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

        return 0;
    }

    public int getNumberOfCorretGuesses(){
        return 0;
    }

    public double getGuessAverage(){
        return 0.0;
    }

    public String getCardName(int row, int col){
        return "";
    }

    public boolean hasBeenFound(int row, int col){
        return false;
    }

    public boolean isMatch(int card1Row, int card1Col, int card2Row, int Card2Col){
        return false;
    }

    public Deck getDeck(){
        return deck;
    }

    public Grid getGrid(){
        return grid;
    }

    
}

