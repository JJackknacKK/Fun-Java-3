//CSDS132 Yingyu Zhu
//This is the Pawn class which extends ChessPiece class while impelement ChessBoard
//It override the capture and noncapture methods to determine if it is a legal move
// A class for The Pawn piece

public class PawnPiece extends ChessPiece{
  
  //Constructor
  public PawnPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column){
    super (chessBoard, side, row, column);
  }
  //Getter method to get lable
  public String getLabel(){
    return "P";
  }
  //This is the method that takes two inputs, that checks if the destination has a piece or not, then check if it is at the same column
  //Then check if it is, then check if the destinaion is only one square away from the current location
  //Then check if the input row is smaller than numRows;
  //Assign it to capture or non-capture.  
  @Override
  public boolean isLegalMove(int toRow, int toColumn){
    if(getSide() == ChessGame.Side.NORTH && toColumn == getColumn()
       && getChessBoard().hasPiece(toRow, toColumn) == false){
      return isLegalNonCaptureMove(toRow, toColumn);
    }
    if(getSide() == ChessGame.Side.SOUTH && toColumn == getColumn()
       && getChessBoard().hasPiece(toRow, toColumn) == false){
      return isLegalNonCaptureMove(toRow, toColumn);
    }
    if(getSide() == ChessGame.Side.NORTH && toRow == getRow()+1 && (toColumn == getColumn()+1 || toColumn == getColumn() -1
       && getChessBoard().hasPiece(toRow, toColumn) == true && getChessBoard().getPiece(toRow, toColumn).getSide() != getSide())){ 
      return isLegalCaptureMove(toRow, toColumn);
    }
    if(getSide() == ChessGame.Side.SOUTH && toRow == getRow()-1 && (toColumn == getColumn()+1 || toColumn == getColumn() -1
       && getChessBoard().hasPiece(toRow, toColumn) == true && getChessBoard().getPiece(toRow, toColumn).getSide() != getSide())){ 
      return isLegalCaptureMove(toRow, toColumn);
    }
     else{
      return false;
     }
       }
     
     
  //This method checks if the the input location has an enemy pieces, return true
  //rest return false
  @Override
  public boolean isLegalCaptureMove(int row, int column){
      return true;
  }
  //This method checks if it is the first move, return true if it is first move;
  //for normal cases, just check if the inputs are the same location as one square away from current location. 
  //else return fasle 
  @Override
  public boolean isLegalNonCaptureMove(int row, int column){
    if(getSide() == ChessGame.Side.NORTH && getIsFirstMove() == true && (row == getRow() + 1 || row == getRow() + 2)){
      return true;
    }
    if(getSide() == ChessGame.Side.SOUTH && getIsFirstMove() == true && (row == getRow() - 1 || row == getRow() - 2)){
      return true;
    }
    if(getSide() == ChessGame.Side.NORTH && (row == getRow() + 1)){
      return true;
    }
    if(getSide() == ChessGame.Side.SOUTH && (row == getRow() - 1)){
      return true;
    }
    else
      return false;
  }
    
  // This sets isFirstMove to be false after the pawn has moved.
  @Override
  public void moveDone(){
    this.setIsFirstMove();
    this.Change();
  }
  //This is the method that if the pawn reach the end oppsite row, it will trun to be any piece the player chooes to be.
  //But not King
  public void Change(){
    if( (getSide() == ChessGame.Side.SOUTH && getRow() ==0)
         || (getSide() == ChessGame.Side.NORTH && getRow() ==7)){
      getChessBoard().removePiece(getRow(), getColumn());
      String s = javax.swing.JOptionPane.showInputDialog("choose from queen, rook, bishop, or knight");
      ChessPiece newPiece;
      if(s.equals("queen")){
        newPiece = new QueenPiece(getChessBoard(), getSide(), getRow(), getColumn());
        getChessBoard().addPiece(newPiece, getRow(), getColumn());
      }
      if(s.equals("bishop")){
        newPiece = new BishopPiece(getChessBoard(), getSide(), getRow(), getColumn());
        getChessBoard().addPiece(newPiece, getRow(), getColumn());
      }
      if(s.equals("rook")){
        newPiece = new RookPiece(getChessBoard(), getSide(), getRow(), getColumn());
        getChessBoard().addPiece(newPiece, getRow(), getColumn());
      }
      if(s.equals("knight")){
        newPiece = new KnightPiece(getChessBoard(), getSide(), getRow(), getColumn());
        getChessBoard().addPiece(newPiece, getRow(), getColumn());
      }
      else{
      
      }
    } 
  }
  }