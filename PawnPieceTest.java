import static org.junit.Assert.*;

import org.junit.Test;

public class PawnPieceTest {

	@Test
	public void testIsLegalMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    PawnPiece pp = new PawnPiece(j, ChessGame.Side.SOUTH, 2, 3);
	    assertEquals("Testing IsLegalMove south side moving to (3, 3)", false, pp.isLegalMove(3, 3));
	    assertEquals("Testing IsLegalMove south side moving to (2, 4)", false, pp.isLegalMove(2, 4));
	    
	}
	@Test
	public void testIsLegalCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    PawnPiece pp = new PawnPiece(j, ChessGame.Side.SOUTH, 2, 3);
	    assertEquals("Testing IsLegalCaptureMove south side moving to (1, 0)", true, pp.isLegalCaptureMove(1, 0));
	    assertEquals("Testing IsLegalCaptureMove south side moving to (2, 4)", true, pp.isLegalCaptureMove(2, 4));
	    
	}
	@Test
	public void testIsLegalNonCaptureMove() {
		EuropeanChess Jackknack = new EuropeanChess();
	    EuropeanChessDisplay Jack = new EuropeanChessDisplay();
	    ChessBoard j = new ChessBoard(8, 8, Jack, Jackknack);
	    
	    PawnPiece pp = new PawnPiece(j, ChessGame.Side.SOUTH, 2, 3);
	    assertEquals("Testing IsLegalNonCaptureMove south side moving to (1, 0)", true, pp.isLegalNonCaptureMove(1, 0));
	    assertEquals("Testing IsLegalNonCaptureMove south side moving to (2, 4)", false, pp.isLegalNonCaptureMove(2, 4));
	    
	}
	
}
