import static org.junit.Assert.*;

import org.junit.Test;

public class ChessBoardImplTest {
  // initialize several pieces
  private Queen whiteQueen = new Queen(0,3,Color.WHITE);
  private Bishop whiteBishop = new Bishop(0, 2, Color.WHITE);
  private Knight whiteKnight = new Knight(0, 1, Color.WHITE);
  private Rook whiteRook = new Rook(0,0, Color.WHITE);
  private Pawn whitePawn = new Pawn(1,1, Color.WHITE);
  private Pawn whitePawn2 = new Pawn(5,4, Color.WHITE);
  private Pawn whitePawn3 = new Pawn(2,0, Color.WHITE);

  private Queen blackQueen = new Queen(2,2,Color.BLACK);
  private Bishop blackBishop = new Bishop(3, 3, Color.BLACK);
  private Knight blackKnight = new Knight(3, 1, Color.BLACK);
  private Rook blackRook = new Rook(3,4, Color.BLACK);
  private Pawn blackPawn = new Pawn(3,2, Color.BLACK);
  private Pawn blackPawn2 = new Pawn(3,5, Color.BLACK);
  private Pawn blackPawn3 = new Pawn(5,2, Color.BLACK);

  // create an array containing the pieces
  private ChessPiece[] startingPieces = {whiteQueen, whiteBishop, whiteKnight, whiteRook, whitePawn,
  blackQueen, blackBishop, blackKnight, blackRook, blackPawn, blackPawn2, blackPawn3, whitePawn2,
  whitePawn3};

  // construct a new board with the pieces
  private ChessBoardImpl myBoard = new ChessBoardImpl(startingPieces);

  // construct an empty board
  private ChessBoardImpl emptyBoard = new ChessBoardImpl();

  /**
   * test Constructor to create an empty board
   */
  @Test
  public void testDefaultConstructor() {
    assertEquals("", emptyBoard.toString());
  }

  /**
   * test Constructor to create a board with several pieces
   */
  @Test
  public void testConstructor() {
    String pieces = """
        Rook{row=0, column=0, color=WHITE}
        Knight{row=0, column=1, color=WHITE}
        Bishop{row=0, column=2, color=WHITE}
        Queen{row=0, column=3, color=WHITE}
        Pawn{row=1, column=1, color=WHITE}
        Pawn{row=2, column=0, color=WHITE}
        Queen{row=2, column=2, color=BLACK}
        Knight{row=3, column=1, color=BLACK}
        Pawn{row=3, column=2, color=BLACK}
        Bishop{row=3, column=3, color=BLACK}
        Rook{row=3, column=4, color=BLACK}
        Pawn{row=3, column=5, color=BLACK}
        Pawn{row=5, column=2, color=BLACK}
        Pawn{row=5, column=4, color=WHITE}
        """;
    assertEquals(pieces, myBoard.toString());
  }

  /**
   * test GetPiece() method,
   * it throws IllegalArgumentException when row or column out of range
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGetPieceException() {
    myBoard.getPiece(-1,9);
  }

  /**
   * test getPiece() method
   */
  @Test
  public void testGetPiece() {
    assertEquals("Queen{row=0, column=3, color=WHITE}",
        myBoard.getPiece(0, 3).toString());
  }

  /**
   * test CanMoveV2() method for Queen,
   * it throws IllegalArgumentException when row or column out of range
   */
  @Test (expected = IllegalArgumentException.class)
  public void testQueenCanMoveV2Exception() {
    whiteQueen.canMoveV2(-1,5, myBoard);
  }

  /**
   * test CanMoveV2() method for Queen in different situations
   */
  @Test
  public void testQueenCanMoveV2() {
    assertTrue(whiteQueen.canMoveV2(3,6, myBoard));  // can move as its pattern
    assertFalse(whiteQueen.canMoveV2(3,4, myBoard));  // can't move not as its pattern
    assertFalse(whiteQueen.canMoveV2(3,4, myBoard));  // can't move when pieces in block
    assertFalse(whiteQueen.canMoveV2(0,1, myBoard));  // can't move to same-color piece

    assertTrue(blackQueen.canMoveV2(1,1, myBoard));  // can move to enemy color
    assertFalse(blackQueen.canMoveV2(0,0, myBoard));  // can't move when pieces in block
    assertFalse(blackQueen.canMoveV2(3,1, myBoard));  // can't move to same-color piece
    assertFalse(blackQueen.canMoveV2(5,2, myBoard));  // can't move when pieces in block
  }

  /**
   * test CanMoveV2() method for Bishop,
   * it throws IllegalArgumentException when row or column out of range
   */
  @Test (expected = IllegalArgumentException.class)
  public void testBishopCanMoveV2Exception() {
    whiteBishop.canMoveV2(-1,9, myBoard);
  }

  /**
   * test CanMoveV2() method for Bishop in different situations
   */
  @Test
  public void testBishopCanMoveV2() {
    assertTrue(whiteBishop.canMoveV2(1,3, myBoard)); // can move as its pattern
    assertFalse(whiteBishop.canMoveV2(1,2, myBoard)); // can't move not as its pattern
    assertFalse(whiteBishop.canMoveV2(1,1, myBoard)); // can't move to same-color piece
    assertTrue(whiteBishop.canMoveV2(3,5, myBoard));  // can move to enemy color

    assertFalse(blackBishop.canMoveV2(1,1, myBoard)); // can't move when pieces in block
    assertFalse(blackBishop.canMoveV2(0,0, myBoard)); // can't move when pieces in block
    assertFalse(blackBishop.canMoveV2(2,2, myBoard)); // can't move to same-color piece
    assertTrue(blackBishop.canMoveV2(7,7, myBoard)); // can move as its pattern
  }

  /**
   * test CanMoveV2() method for Knight,
   * it throws IllegalArgumentException when row or column out of range
   */
  @Test (expected = IllegalArgumentException.class)
  public void testKnightCanMoveV2Exception() {
    whiteKnight.canMoveV2(-1,-5, myBoard);
  }

  /**
   * test CanMoveV2() method for Knight in different situations
   */
  @Test
  public void testKnightCanMoveV2() {
    assertTrue(whiteKnight.canMoveV2(1,3, myBoard)); // can move as its pattern
    assertFalse(whiteKnight.canMoveV2(1,2, myBoard)); // can't move not as its pattern
    assertTrue(whiteKnight.canMoveV2(2,2, myBoard));  // can move to enemy color
                                                              // even though pieces in block
    assertFalse(whiteKnight.canMoveV2(5,2, myBoard)); // can't move to same-color piece
  }

  /**
   * test CanMoveV2() method for Rook,
   * it throws IllegalArgumentException when row or column out of range
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRookCanMoveV2Exception() {
    blackRook.canMoveV2(-1,0, myBoard);
  }

  /**
   * test CanMoveV2() method for Rook in different situations
   */
  @Test
  public void testRookCanMoveV2() {
    assertTrue(whiteRook.canMoveV2(1,0, myBoard));  // can move as its pattern
    assertFalse(blackRook.canMoveV2(2,5, myBoard));  // can't move not as its pattern
    assertFalse(blackRook.canMoveV2(3,6, myBoard));  // can't move when pieces in block
    assertFalse(whiteRook.canMoveV2(0,1, myBoard));  // can't move to same-color piece
    assertTrue(blackRook.canMoveV2(5,4, myBoard));  // can move to enemy color
  }

  /**
   * test CanMoveV2() method for Pawn,
   * it throws IllegalArgumentException when row or column out of range
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPawnCanMoveV2Exception() {
    blackPawn.canMoveV2(9,8, myBoard);
  }

  /**
   * test CanMoveV2() method for Pawn in different situations
   */
  @Test
  public void testPawnCanMoveV2() {
    assertTrue(whitePawn.canMoveV2(2,1, myBoard));  // can move as its pattern
    assertFalse(whitePawn.canMoveV2(1,0, myBoard));  // can't move not as its pattern
    assertFalse(blackPawn.canMoveV2(4,2, myBoard));  // can't move not as its pattern
    assertFalse(whitePawn.canMoveV2(2,0, myBoard));  // can't move to same-color piece
    assertTrue(whitePawn.canMoveV2(2,2, myBoard));  // can move to enemy color
  }
}