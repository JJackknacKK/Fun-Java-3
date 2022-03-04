//CSDS132 Yingyu Zhu
//This is an abstract class at the top of hierarchy, which also implements the interface ChessGame
//It contains all the methods and instance variables that other classes which extends ChessPiece needs.
//Pawn, Bishop, Quenn,King,Knight,and Rook all extends ChessPiece
public abstract class ChessPiece{
  
  //Here are all the instance variables that needs to initiailze it.
  private ChessGame.Side side;
  private String label;
  private ChessBoard chessBoard;
  private Object icon;
  private int column;
  private int row;
  //This boolean variable works for the getter/setter methods for isFirstMove only for pawn. 
  private boolean isFirstMove = true;
  private boolean neverMoved = true;
  
  public ChessPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column){
    this.chessBoard = chessBoard;
    this.side = side;
    this.row = row;
    this.column = column;
  }

  //return this piece belongs to whom
  public ChessGame.Side getSide(){
    return side;
  }
  
  //Return the lable for the pieces
  public String getLabel(){
    return label;
  }
  
  //return the Icon for pieces
  public Object getIcon(){
    return icon;
  }
  
  //Set the location of the piece from the current location to the input location. 
  public void setLocation(int row, int column){
    this.row = row;
    this.column = column;
  }
  
  //First step to check if is legl to move
  //It checks if there is an enemy piece at destination or not, and call islegalcapture or islegalnoncapturemove as appropriate. 
  public boolean isLegalMove(int toRow, int toColumn){
    if(getChessBoard().hasPiece(toRow, toColumn) == false){
      return isLegalNonCaptureMove(toRow, toColumn);
    }
    if(getChessBoard().hasPiece(toRow, toColumn) == true){
      return isLegalCaptureMove(toRow, toColumn);
    }
    else
      return false;
  }
  
  //get a chessboard which places all the chess pieces.
  //Also helps to use functions that are stroed in the ChessBoard class
  public ChessBoard getChessBoard(){
    return chessBoard;
  }
  
  //To get the row of the currect location.
  public int getRow(){
    return row;
  }
  
  //To get the column of the currect location. 
  public int getColumn(){
    return column;
  }
  
  //This is the mthod to check if the move is legal when there is not an emeny piece at destination.
  //It will be override for every single Chess pieces. To follow up the condition
  public boolean isLegalNonCaptureMove(int row, int column){
    return true;
  }
  
  //This is the mthod to check if the move is legal when there is an emeny piece at destination.
  //It will be override for every single Chess pieces. To follow up the condition
  public boolean isLegalCaptureMove(int row, int column){
    return true;
  }
  
  //Waiting for other class to override it.
  public void moveDone(){
  
  }
  
  //These two getter and setter methods are to get access for PawnPiece class
  //In order to check if the Pawn can move one/two space 
  public boolean getIsFirstMove(){
    return isFirstMove;
  }
  
  public void setIsFirstMove(){
    this.isFirstMove = false;
  }
  //These two getter and setter methods are to get access for kingPiece class
  //in order to achieve the castling. 
  public boolean getNeverMoved(){
    return neverMoved;
  }
  
  public void setNeverMoved(){
    neverMoved = true;
  }
}