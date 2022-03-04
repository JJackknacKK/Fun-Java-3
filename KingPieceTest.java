import static org.junit.Assert.*;

import org.junit.Test;

public class KingPieceTest {

	@Test
	public void testLegalNonCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    KingPiece kp = new KingPiece(j, ChessGame.Side.NORTH, 4, 4);
	    assertEquals("Testing IsLegalNonCaptureMove north side moving to (1, 1)", false, kp.isLegalNonCaptureMove(1, 1));
	    assertEquals("Testing IsLegalNonCaptureMove north side moving to (3, 4)", true, kp.isLegalNonCaptureMove(3, 4));
	    
	}
	@Test
	public void testLegalCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    KingPiece kp = new KingPiece(j, ChessGame.Side.NORTH, 4, 4);
	    assertEquals("Testing IsLegalCaptureMove north side moving to (1, 1)", false, kp.isLegalCaptureMove(1, 1));
	    assertEquals("Testing IsLegalCaptureMove north side moving to (3, 4)", true, kp.isLegalCaptureMove(3, 4));
	    
	}
}
