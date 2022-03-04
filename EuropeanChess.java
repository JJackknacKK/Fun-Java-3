//This is the class that compleme all the nesscary methos that needs to launch the game
public class EuropeanChess implements ChessGame{
  
  //we create a variable turn and use it do decide which payers gets to paly first 
  //and then we use it as the to switch players
  private ChessGame.Side turn = ChessGame.Side.NORTH;
  //This is like a constructor which set up for different players for us to use.
  public enum Side {NORTH, SOUTH, EAST, WEST};
  //This is the function, which checks if the piece is legal to play
  //By checking the piece belongs to whom using turn and getSide()
  public boolean legalPieceToPlay(ChessPiece piece, int toRow, int toColumn){
  if(turn == (piece.getSide()))
    return true;
  else
    return false;
  }
  //This is the function we need to call every time when we want to move a piece
  //It checks if is legal to move and then check the side of the piece to see if it belongs to the same side player
  //Then we remove the old piece from the current location and add a new one to the denstiation
  //Then call move done, (some pieces such as pawn and king are different
  //Finally we switch players, and return true or false to show if we moved the piece or not. 
  public boolean makeMove(final ChessPiece piece, int toRow, int toColumn){
    if(piece.isLegalMove(toRow, toColumn) ==true && turn == (piece.getSide())){
      piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
      piece.getChessBoard().addPiece(piece, toRow, toColumn);
      piece.moveDone();
      if(turn == ChessGame.Side.NORTH){
        turn = ChessGame.Side.SOUTH;
      }
      else if(turn ==ChessGame.Side.SOUTH){
        turn = ChessGame.Side.NORTH;
      }
      else{
      return false;
      }
  }
   return true;
  }

    //This is main method to launch the whole thing. It get a chessboard to display
    //It also sets all the needed pieces on the chessboard
    //It applys all game rule, function like make move to play the chess game
    //Finally we print out the EuropeanChessDisplay and Chessboard to play the game.
    public static void main(String[] args){
    EuropeanChess Jackknack = new EuropeanChess();
    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
    for(int i = 0; i < j.numColumns(); i++){
      j.addPiece(new PawnPiece(j, ChessGame.Side.NORTH, 1, i), 1, i);
      j.addPiece(new PawnPiece(j, ChessGame.Side.SOUTH, 6, i), 6, i);
    if(i == 0 || i == 7){
      j.addPiece(new RookPiece(j, ChessGame.Side.NORTH, 0, i), 0, i);
      j.addPiece(new RookPiece(j, ChessGame.Side.SOUTH, 7, i), 7, i);
    }
    if(i == 6 || i == 1){
      j.addPiece(new KnightPiece(j, ChessGame.Side.NORTH, 0, i), 0, i);
      j.addPiece(new KnightPiece(j, ChessGame.Side.SOUTH, 7, i), 7, i);
    }
    if(i == 2 || i == 5){
    j.addPiece(new BishopPiece(j, ChessGame.Side.NORTH, 0, i), 0, i);
    j.addPiece(new BishopPiece(j, ChessGame.Side.SOUTH, 7, i), 7, i);
    }
    if(i == 3){
      j.addPiece(new QueenPiece(j, ChessGame.Side.NORTH, 0, i), 0, i);
      j.addPiece(new QueenPiece(j, ChessGame.Side.SOUTH, 7, i), 7, i);
    }
    if(i == 4){
      j.addPiece(new KingPiece(j, ChessGame.Side.NORTH, 0, i), 0, i);
      j.addPiece(new KingPiece(j, ChessGame.Side.SOUTH, 7, i), 7, i);
    }
  }
  System.out.println(Jack);
  System.out.println(j);
  
  }
}