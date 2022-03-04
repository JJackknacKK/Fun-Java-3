import static org.junit.Assert.*;

import org.junit.Test;

public class EuropeanChessTest {

	@Test
	public void testLegalPieceToPlay() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard board = new ChessBoard(8, 8, Jack, Jackknack);
	    RookPiece northpiece = new RookPiece(board, ChessGame.Side.NORTH, 1, 2);
	    RookPiece southpiece = new RookPiece(board, ChessGame.Side.SOUTH, 1, 2);
	    assertEquals("Testing if it's legal to play", true, Jackknack.legalPieceToPlay(northpiece, 1, 3));
	    assertEquals("Testing if it's legal to play now", false, Jackknack.legalPieceToPlay(southpiece, 1, 3));
	}
	
	@Test
	public void testMakeMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard board = new ChessBoard(8, 8, Jack, Jackknack);
	    RookPiece northpiece = new RookPiece(board, ChessGame.Side.NORTH, 1, 2);
	    RookPiece westpiece = new RookPiece(board, ChessGame.Side.WEST, 1, 2);
	    assertEquals("Testing if it could make move", true, Jackknack.makeMove(northpiece, 1, 3));
	    assertEquals("Testing if it could not make move", false, Jackknack.legalPieceToPlay(westpiece, 1, 3));
	}
	

}
