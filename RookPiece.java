//CSDS132 Yingyu Zhu
//This is the rook class which extends ChessPiece class while impelement ChessBoard
//It override the capture and noncapture methods to determine if it is a legal move
public class RookPiece extends ChessPiece{
  //Constructor
  public RookPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column){
	super (chessBoard, side, row, column);
  }
  //Rook can only move horizontally or vertically. So, it will have 4 possibilities within two categories
  //Categorie-1 moves vertically, having the same row, but move left or right.
  //Categorie-2 moves horizontally, having the same column, but moves up or down. 
  //They all check if the input values are greater than 0 and smaller than the numRows/numColumns
  @Override
  public boolean isLegalNonCaptureMove(int row, int column){
    //This is the Categorie-1, check for row first, if the same, then....
    if(getRow() == row && column <= getChessBoard().numColumns() && column > 0 && row >=0){
      //Categorie-1, condition-1 move to the left, if current column is greater than the input column
      //Checks every square between the current location to the destination, if there are any chess pieces.
      if(getColumn() > column){
        for(int i = (getColumn() - 1); i >= column; i--){
          getChessBoard().hasPiece( getRow(), i);
          if(getChessBoard().hasPiece(getRow(), i) == true){
            return false;
          }
        }
      
      }
      //Categorie-1, Condition-2, move to the right, if the current column is less than the input one.
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
    //This is the categorie-2, check the column is the same or not, if true...
    else if(getColumn() == column && row <= getChessBoard().numRows()){
      //Categorie-2, condition-3, move down, if the current row is greater than the input one
      //Checks every square between the current location to the destination, if there are any chess pieces.
      if(getRow() > row){
        for(int j = (getRow() - 1); j >= row; j--){
          getChessBoard().hasPiece(j, getColumn());
          if(getChessBoard().hasPiece(j, getColumn()) == true){
            return false;
          }
        }
      }
      //Categorie-2, condition-4, move up, if the current row is smaller than the input one
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
    else
      return false;
    
    return true;
  }
  
  //This is exactly the same as the one above 
  @Override
  public boolean isLegalCaptureMove(int row, int column){
    //This is the Categorie-1, check for row first, if the same, then....
    if(getRow() == row && column <= getChessBoard().numColumns() && column >= 0 && row >= 0){
      //Categorie-1, condition-1 move to the left, if current column is greater than the input column
      //Checks every square between the current location to the destination, if there are any chess pieces.
      if(getColumn() > column){
        for(int i = (getColumn() -1); i >= column; i--){
          getChessBoard().hasPiece( getRow(), i);
          if(getChessBoard().hasPiece(getRow(), i) == true){
            return false;
          }
        }
      }
      //Categorie-1, Condition-2, move to the right, if the current column is less than the input one.
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
    //This is the categorie-2, check the column is the same or not, if true...
    else if(getColumn() == column && row <= getChessBoard().numRows()){
      //Categorie-2, condition-3, move down, if the current row is greater than the input one
      //Checks every square between the current location to the destination, if there are any chess pieces.
      if(getRow() > row){
        for(int j = (getRow() -1); j >= row; j--){
          getChessBoard().hasPiece(j, getColumn());
          if(getChessBoard().hasPiece(j, getColumn()) == true){
            return false;
          }
        }
      }
      //Categorie-2, condition-4, move up, if the current row is smaller than the input one
      //Checks every square between the current location to the destination, if there are any chess pieces.
      else if(getRow() < row){
        for(int k = (getRow() +1); k <= row; k++){
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
    //ANY condition besides the MAIN TWO CATEGORIES, returns false 
    else{
      return false;
    }
    //If there are no pieces on the way to its destination, which means go through the loop successfully, return true
    //It is legal to move
  return true;
  }
}