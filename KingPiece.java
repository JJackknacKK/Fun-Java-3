//CSDS 132 Yingyu Zhu
public class KingPiece extends ChessPiece{
  //Constructor
  public KingPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column){
    super (chessBoard, side, row, column);
  }
  //Getter method to get lable
  public String getLabel(){
    return "K";
  }
  //This is the king class which extends ChessPiece class
  //It override the capture and noncapture methods to determine if it is a legal move
  //Two methods are exactly the same since it already checks if there is an enemy piece or not. 
  //They all contains 8 possibilities, in 4 categories.
  //They all check if the input values are less than numRows/numColumns
  
  @Override
  public boolean isLegalNonCaptureMove(int row, int column){
    //Categories-1, moves up or down. Same Column, goes up one or down one. 
    if(getColumn() == column && ( getRow() + 1 == row || getRow() - 1 == row) && row <= getChessBoard().numRows() ){
      return true;
    }
    //Categories-2, moves right or left. Same row, goes left one of right one.
    if(getRow() == row && ( getColumn() + 1 == column || getColumn() -1 == column) && column <= getChessBoard().numColumns()){
      return true;
    }
    //Categorie3, moves to left+up or left+down. 
    if(column == getColumn() - 1 && (row == getRow() + 1 || row == getRow() - 1) && column <= getChessBoard().numColumns() && row <= getChessBoard().numRows()){
      return true;
    }
    //Categorie4, moves to right+up or right+down
    if(column == getColumn() + 1 && (row == getRow() + 1 || row == getRow() - 1) && column <= getChessBoard().numColumns() && row <= getChessBoard().numRows()){
      return true;
    }
    //Any condition besides these are not legal to move
    else
      return false;
  }
    
    
  @Override
  public boolean isLegalCaptureMove(int row, int column){
    //Categories-1, moves up or down. Same Column, goes up one or down one. 
    if(getColumn() == column && ( getRow() + 1 == row || getRow() - 1 == row) && row <= getChessBoard().numRows() ){
      return true;
    }
    //Categories-2, moves right or left. Same row, goes left one of right one.
    if(getRow() == row && ( getColumn() + 1 == column || getColumn() -1 == column) && column <= getChessBoard().numColumns()){
      return true;
    }
    //Categorie3, moves to left+up or left+down.
    if(column == getColumn() - 1 && (row == getRow() + 1 || row == getRow() - 1) && column <= getChessBoard().numColumns() && row <= getChessBoard().numRows()){
      return true;
    }
    //Categorie4, moves to right+up or right+down
    if(column == getColumn() + 1 && (row == getRow() + 1 || row == getRow() - 1) && column <= getChessBoard().numColumns() && row <= getChessBoard().numRows()){
      return true;
    }
    //Any condition besides these are not legal to move
    else
      return false;
  }
  

  public void moveDone(){
      setNeverMoved();
    }
  }
  
  
  
  
  
  
  
  
 