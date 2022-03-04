//CSDS132 Yingyu Zhu
public class KnightPiece extends ChessPiece{
  //Constructor
  public KnightPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column){
    super (chessBoard, side, row, column);
  }
  //Getter method to get lable
  public String getLabel(){
    return "N";
  }
  //This is the knight class which extends ChessPiece class
  //It override the capture and noncapture methods to determine if it is a legal move
  //Two methods are exactly the same
  //They all contains 8 possibilities
  //Everytime check if the input values are bigger than 0 and smaller than numRows+numColumns()
  //The 8 possibilities are
  //up 2 right 1 --- up 2 left 1---down 2 right 1---down 2 left ---1
  //right 2 left 1----right 2 right 1---left 2 right 1---left 2 left 1
  @Override
  public boolean isLegalNonCaptureMove(int row, int column){
    
    if((getRow() + 2) == row && (getColumn() + 1) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() + 2) == row && (getColumn() - 1) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() - 2) == row && (getColumn() + 1) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() - 2) == row && (getColumn() - 1) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() - 1) == row && (getColumn() + 2) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() + 1) == row && (getColumn() + 2) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() + 1) == row && (getColumn() - 2) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() - 1) == row && (getColumn() - 2) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    else
      return false;
  }
  
  @Override
  public boolean isLegalCaptureMove(int row, int column){
    if((getRow() + 2) == row && (getColumn() + 1) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() + 2) == row && (getColumn() - 1) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() - 2) == row && (getColumn() + 1) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() - 2) == row && (getColumn() - 1) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() - 1) == row && (getColumn() + 2) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() + 1) == row && (getColumn() + 2) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() + 1) == row && (getColumn() - 2) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    if((getRow() - 1) == row && (getColumn() - 2) == column && row <= getChessBoard().numRows() && column <= getChessBoard().numColumns() && row >= 0 && column >= 0){
      return true;
    }
    else
      return false;
  }
}
