//CSDS132 Yingyu Zhu
//This is the quenn class which extends ChessPiece class while impelement ChessBoard
//It override the capture and noncapture methods to determine if it is a legal move
//Quenn can move horizontal, vertical, and diagonal, So we check them seperatly.
//The two method are the exact same, with a different int variable. 
public class QueenPiece extends ChessPiece{
  
  //Constructor
  public QueenPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column){
    super (chessBoard, side, row, column);
  }
  //Getter method to get lable
  public String getLabel(){
    return "Q";
  }
  @Override
  public boolean isLegalNonCaptureMove(int row, int column){
    
    //Horizontal
    //If the quenn moves horizontally, it will move in the same row, but to different columns.
    //check if the row are the same, then check for columns. If input are smaller then it moves to the left
    //If input are bigger, then moves to the right. Additionally, both inout number must be greater than zero.  
    if(getRow() == row && column <= getChessBoard().numColumns() && column > 0 && row >=0){
      //This tests for the Quenn moves to the right. 
      //Checks every square between the current location to the destination, if there are any chess pieces.
      if(getColumn() > column){
        for(int i = (getColumn() - 1); i >= column; i--){
          getChessBoard().hasPiece( getRow(), i);
          if(getChessBoard().hasPiece(getRow(), i) == true){
            return false;
          }
        }
      }
      //This tests for the Quenn moves to the left.
      //Checks every square between the current location to the destination, if there are any chess pieces.
      else if(getColumn() < column) {
        for(int index = (getColumn() + 1); index <= column; index++){
          getChessBoard().hasPiece( getRow(), index);
          if(getChessBoard().hasPiece( getRow(), index) == true){
            return false;
          }
        }
      }
      //Any cases besides those two, return false
      else{
        return false;
      }
    }
    //Vertical
    //check if the column are the same, then check for rows. If input are smaller then it moves down
    //If input are bigger, then moves up. Additionally, both inout number must be greater than zero.
    if(getColumn() == column && row <= getChessBoard().numRows()){
      //Here tests if the Quenn is moving down
      //Checks every square between the current location to the destination, if there are any chess pieces.
      if(getRow() > row){
        for(int j = (getRow() - 1); j >= row; j--){
          getChessBoard().hasPiece(j, getColumn());
          if(getChessBoard().hasPiece(j, getColumn()) == true){
            return false;
          }
        }
      }
      //Here tests if the Quenn is moving up.
      //Checks every square between the current location to the destination, if there are any chess pieces.
      else if(getRow() < row){
        for(int k = (getRow() + 1); k <= row; k++){
          getChessBoard().hasPiece(k, getColumn());
          if(getChessBoard().hasPiece(k, getColumn()) == true){
            return false;
          }
        }
      }
      //Any cases besides those two, return false
      else
        return false;
    }
    //If quenn move digonally, so there are four directions. Divided into two categories
    //So we check for the categories1 1. If the sum are the same, the input values are less or equal than the numRows/Columns and bigger than zero
    if( (row + column) == (getRow() + getColumn()) && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0 ){
      
      //Then we check for conditions 1 and 2 seperately. 
      //Check for 1. up+right. So input row must be bigger and input colums must be smaller.
      //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immeditately
      if(row < getRow() && column > getColumn()){
         //This int variables is to store the column value
         //And it varies in different loops to help check if there are pieces or not in the pathway to destination. 
         int index = this.getColumn() + 1;
        for(int i = (getRow() - 1); i < row; i--){
          getChessBoard().hasPiece(i, (index));
          if(getChessBoard().hasPiece( i , index) == true){
            return false;
          }
          index = index + 1;
        }
      }
      //Here is condition 2. down+left. input row and column need to be smallee
      //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immeditately
      else if(row > getRow() && column < getColumn()) {
         //This int variables is to store the column value
         //And it varies in different loops to help check if there are pieces or not in the pathway to destination. 
         int x = this.getColumn() - 1;
         for(int j = (getRow() + 1); j > row; j++){
          getChessBoard().hasPiece(j, x);
          if(getChessBoard().hasPiece( j, x) == true){
            return false;
          }
          x = x - 1;
        }
      }
      //anything else, such as input row = current row or input column = current column.
      //return flase
      else
        return false;
    }
    
    //Here is the Categorie2 which checks 3 up+left and 4 down+right seperatly
    //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immeditately
    else if( (column -row) == (getColumn() - getRow()) && row >= 0 && column >= 0 ){
       //This int variables is to store the column value
       //And it varies in different loops to help check if there are pieces or not in the pathway to destination. 
       int c = this.getColumn() - 1;
      //Here is the condition 3 up+left. input row and column must be bigger. Then go through the loop
      if( row < getRow() && column < getColumn()){
        for(int k = (getRow() - 1); k < row; k--){
          getChessBoard().hasPiece(k, c);
          if(getChessBoard().hasPiece( k, c) == true){
            return false;
          }
          c = c - 1;
        }
      }
      //Here is the condition 4 down+right. Input row needs to be smaller and input column needs to be bigger
      //Go through the loop and return false if there are any pieces on the way. 
      else if(row > getRow() && column > getColumn()){
        //This int variables is to store the column value
        //And it varies in different loops to help check if there are pieces or not in the pathway to destination. 
        int v = this.getColumn() + 1;
        for(int n = (getRow() + 1); n > row; n++){
          getChessBoard().hasPiece(n, v);
          if(getChessBoard().hasPiece( n, v) == true){
            return false;
          }
          v = v + 1;
        }
      }
    }
    //ANY condition besides the MAIN TWO CATEGORIES, returns false 
    else{
      return false;
    }
    //If there are no pieces on the way to its destination, which means go through the loop successfully, return true
    //It is legal to move
    return true;
  }
  
  @Override
  public boolean isLegalCaptureMove(int row, int column){
    
    //This is the int variable that stores the column numder later for the diagonal part
    int q = this.getColumn();
    
    //Horizontal
    //If the quenn moves horizontally, it will move in the same row, but to different columns.
    //check if the row are the same, then check for columns. If input are smaller then it moves to the left
    //If input are bigger, then moves to the right. Additionally, both inout number must be greater than zero.
    if(getRow() == row && column <= getChessBoard().numColumns() && column > 0 && row >=0){
      //This tests for the Quenn moves to the right.
      //Checks every square between the current location to the destination, if there are any chess pieces.
      if(getColumn() > column){
        for(int i = (getColumn() - 1); i >= column; i--){
          getChessBoard().hasPiece( getRow(), i);
          if(getChessBoard().hasPiece(getRow(), i) == true){
            return false;
          }
        }
      }
      //This tests for the Quenn moves to the left.
      //Checks every square between the current location to the destination, if there are any chess pieces.
      else if(getColumn() < column) {
        for(int index = (getColumn() + 1); index <= column; index++){
          getChessBoard().hasPiece( getRow(), index);
          if(getChessBoard().hasPiece( getRow(), index) == true){
            return false;
          }
        }
      }
      //Any cases besides those two, return false
      else{
        return false;
      }
    }
    //Vertical
    //check if the column are the same, then check for rows. If input are smaller then it moves down
    //If input are bigger, then moves up. Additionally, both inout number must be greater than zero.
    if(getColumn() == column && row <= getChessBoard().numRows()){
      //Here tests if the Quenn is moving down.
      //Checks every square between the current location to the destination, if there are any chess pieces.
      if(getRow() > row){
        for(int j = (getRow() - 1); j >= row; j--){
          getChessBoard().hasPiece(j, getColumn());
          if(getChessBoard().hasPiece(j, getColumn()) == true){
            return false;
          }
        }
      }
      //Here tests if the Quenn is moving up.
      //Checks every square between the current location to the destination, if there are any chess pieces.
      else if(getRow() < row){
        for(int k = (getRow() + 1); k <= row; k++){
          getChessBoard().hasPiece(k, getColumn());
          if(getChessBoard().hasPiece(k, getColumn()) == true){
            return false;
          }
        }
      }
      //Any cases besides those two, return false
      else
        return false;
    }
    
    //If quenn move digonally, so there are four directions. Divided into two categories
    //So we check for the categories1 1. If the sum are the same, the input values are less or equal than the numRows/Columns and bigger than zero
    if( (row + column) == (getRow() + getColumn()) && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0 ){
      
      //Then we check for conditions 1 and 2 seperately. 
      //Check for 1. up+right. So input row must be bigger and input colums must be smaller.
      //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immeditately
      if(row < getRow() && column > getColumn()){
         //This int variables is to store the column value
         //And it varies in different loops to help check if there are pieces or not in the pathway to destination. 
         int index = this.getColumn() + 1;
        for(int i = (getRow() - 1); i < row; i--){
          getChessBoard().hasPiece(i, (index));
          if(getChessBoard().hasPiece( i , index) == true){
            return false;
          }
          index = index + 1;
        }
      }
      //Here is condition 2. down+left. input row and column need to be smallee
      //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immeditately
      else if(row > getRow() && column < getColumn()) {
         //This int variables is to store the column value
         //And it varies in different loops to help check if there are pieces or not in the pathway to destination. 
         int x = this.getColumn() - 1;
         for(int j = (getRow() + 1); j > row; j++){
          getChessBoard().hasPiece(j, x);
          if(getChessBoard().hasPiece( j, x) == true){
            return false;
          }
          x = x - 1;
        }
      }
      //anything else, such as input row = current row or input column = current column.
      //return flase
      else
        return false;
    }
    
    //Here is the Categorie2 which checks 3 up+left and 4 down+right seperatly
    //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immeditately
    else if( (column -row) == (getColumn() - getRow()) && row >= 0 && column >= 0 ){
       //This int variables is to store the column value
       //And it varies in different loops to help check if there are pieces or not in the pathway to destination. 
       int c = this.getColumn() - 1;
      //Here is the condition 3 up+left. input row and column must be bigger. Then go through the loop
      if( row < getRow() && column < getColumn()){
        for(int k = (getRow() - 1); k < row; k--){
          getChessBoard().hasPiece(k, c);
          if(getChessBoard().hasPiece( k, c) == true){
            return false;
          }
          c = c - 1;
        }
      }
      //Here is the condition 4 down+right. Input row needs to be smaller and input column needs to be bigger
      //Go through the loop and return false if there are any pieces on the way. 
      else if(row > getRow() && column > getColumn()){
        //This int variables is to store the column value
        //And it varies in different loops to help check if there are pieces or not in the pathway to destination. 
        int v = this.getColumn() + 1;
        for(int n = (getRow() + 1); n > row; n++){
          getChessBoard().hasPiece(n, v);
          if(getChessBoard().hasPiece( n, v) == true){
            return false;
          }
          v = v + 1;
        }
      }
    }
    //ANY condition besides the MAIN TWO CATEGORIES, returns false 
    else{
      return false;
    }
    //If there are no pieces on the way to its destination, which means go through the loop successfully, return true
    //It is legal to move
    return true;
  }
}
  
