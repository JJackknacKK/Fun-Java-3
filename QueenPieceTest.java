import static org.junit.Assert.*;

import org.junit.Test;

public class QueenPieceTest {

	@Test
	public void testIsLegalNonCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    QueenPiece qp = new QueenPiece(j, ChessGame.Side.SOUTH, 0, 0);
	    assertEquals("Testing south side moving to (1, 0)", false, qp.isLegalNonCaptureMove(1, 0));
	    
	    QueenPiece qp2 = new QueenPiece(j, ChessGame.Side.SOUTH, 5, 5);
	    assertEquals("Testing south side moving to (5, 4)", false, qp.isLegalNonCaptureMove(5, 4));
	    
	}
	@Test
	public void testisLegalCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    QueenPiece qp = new QueenPiece(j, ChessGame.Side.SOUTH, 3, 3);
	    assertEquals("Testing south side moving to (1, 0)", false, qp.isLegalCaptureMove(1, 0));
	    assertEquals("Testing south side moving to (2, 4)", true, qp.isLegalCaptureMove(2, 4));
	}
}
