public class Grid {

    //Instance fields-----------------------------
    int rows;
    int cols;
    Card[][] cards;



    //Constructor----------------------------------
    public Grid(int rows, int cols){
        cards = new Card[rows][cols];
    }

    //Methods-------------------------------------
    
    
    public void setCard(int row, int col, Card card){
        if(card == null) {
            throw new IllegalArgumentException("Null card");
        }
        if(row < 0 || row >= this.rows){
            throw new IllegalArgumentException("Invalid row");
        }
        if(col < 0 || col >= this.cols){
            throw new IllegalArgumentException("Invalid col");
        }

        cards[row][col] = card;


    }


    public Card getCard(int row, int col){
        return (new Card('h', 2));
    }

    public String toString(){

        return "";
    }







}