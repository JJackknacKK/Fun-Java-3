import static org.junit.Assert.*;

import org.junit.Test;

public class BishopPieceTest {

	@Test
	public void testIsLegalNonCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    BishopPiece bp = new BishopPiece(j, ChessGame.Side.SOUTH, 4, 4);
	    assertEquals("Testing IsLegalNonCaptureMove south side moving to (1, 1)", true, bp.isLegalNonCaptureMove(1, 1));
	    assertEquals("Testing IsLegalNonCaptureMove south side moving to (3, 4)", false, bp.isLegalNonCaptureMove(3, 4));
	    
	}
	@Test
	public void testIsLegalCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    BishopPiece bp = new BishopPiece(j, ChessGame.Side.SOUTH, 4, 4);
	    assertEquals("Testing IsLegalCaptureMove south side moving to (1, 1)", true, bp.isLegalCaptureMove(1, 1));
	    assertEquals("Testing IsLegalCaptureMove south side moving to (3, 4)", false, bp.isLegalCaptureMove(3, 4));
	    
	}
}
