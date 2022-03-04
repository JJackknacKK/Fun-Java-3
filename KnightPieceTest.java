import static org.junit.Assert.*;

import org.junit.Test;

public class KnightPieceTest {

	@Test
	public void testIsLegalNonCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    KnightPiece kp = new KnightPiece(j, ChessGame.Side.NORTH, 4, 4);
	    assertEquals("Testing IsLegalNonCaptureMove north side moving to (1, 1)", false, kp.isLegalNonCaptureMove(1, 1));
	    assertEquals("Testing IsLegalNonCaptureMove north side moving to (7, 1)", false, kp.isLegalNonCaptureMove(7, 1));
	    assertEquals("Testing IsLegalNonCaptureMove north side moving to (5, 2)", true, kp.isLegalNonCaptureMove(5, 2));
	    
	}
	@Test
	public void testIsLegalCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    KnightPiece kp = new KnightPiece(j, ChessGame.Side.NORTH, 4, 4);
	    assertEquals("Testing IsLegalCaptureMove north side moving to (1, 1)", false, kp.isLegalCaptureMove(1, 1));
	    assertEquals("Testing IsLegalCaptureMove north side moving to (7, 1)", false, kp.isLegalCaptureMove(7, 1));
	    assertEquals("Testing IsLegalCaptureMove north side moving to (5, 2)", true, kp.isLegalCaptureMove(5, 2));
	    
	}

}
