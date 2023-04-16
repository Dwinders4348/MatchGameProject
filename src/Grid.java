public class Grid {

    //Instance fields-----------------------------
    int rows;
    int cols;
    Card[][] cards;



    //Constructor----------------------------------
    public Grid(int rows, int cols){
        if(rows < 1 || cols < 1){
            throw new IllegalArgumentException("Invalid rows/cols");
        }

        this.rows = rows;
        this.cols = cols;

        cards = new Card[rows][cols];
    }

    //Methods-------------------------------------
    
    
    public void setCard(int row, int col, Card card){ 
        if(card == null) {
            throw new IllegalArgumentException("Null card");
        }
        if(row < 0 || row >= rows){
            throw new IllegalArgumentException("Invalid row");
        }
        if(col < 0 || col >= cols){
            throw new IllegalArgumentException("Invalid col");
        }

        cards[row][col] = card;


    }


    public Card getCard(int row, int col){
        if(row < 0 || row >= this.rows){
            throw new IllegalArgumentException("Invalid row");
        }
        if(col < 0 || col >= this.cols){
            throw new IllegalArgumentException("Invalid col");
        }
        
        return cards[row][col];
    }

    public String toString(){
        
        String grid = "";
        
        for (int i = 0; i < this.rows; i++){

            for (int j = 0; j < this.cols; j++){

                grid += cards[i][j].toString();
                if(!(j+1 == this.cols)){
                    grid += " ";
                }

            }
            
            if(!(i == this.rows)){
                grid += "\n";
            }
        }
        
        return grid;
    }







}