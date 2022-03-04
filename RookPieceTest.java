import static org.junit.Assert.*;

import org.junit.Test;

public class RookPieceTest {

	@Test
	public void testIsLegalNonCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    RookPiece rp = new RookPiece(j, ChessGame.Side.NORTH, 0, 0);
	    assertEquals("Testing north side moving to (1, 0)", true, rp.isLegalNonCaptureMove(1, 0));
	    assertEquals("Testing north side moving to (1, 2)", false, rp.isLegalNonCaptureMove(1, 2));
	}
	@Test
	public void testisLegalCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    RookPiece rp = new RookPiece(j, ChessGame.Side.NORTH, 0, 0);
	    assertEquals("Testing if is legal CaptureMove north side moving to (1, 0)", true, rp.isLegalCaptureMove(1, 0));
	    assertEquals("Testing if is legal CaptureMove north side moving to (1, 2)", false, rp.isLegalCaptureMove(1, 2));
	}

}
