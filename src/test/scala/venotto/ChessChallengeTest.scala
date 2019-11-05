package venotto

import org.scalatest._
import venotto.model._

/*
*Piotr Bojnowski
 */

class ChessChallengeTest extends FlatSpec with Matchers {

  "Method getAllUniqueSafeConfigurations()" should "should retun 0 elements if Pieces.size > board.size" in {
    val pieces = List(Knight, Knight, Rook, Rook, Knight, Knight, Knight, Knight, Rook, Rook, Knight, Knight)
    val chessBoard = ChessBoard(2, 2)
    chessBoard.getAllUniqueSafeConfigurations(pieces)

    assert(chessBoard.boardUniqueConfiguration.isEmpty)
  }

  "Method getAllUniqueSafeConfigurations()" should "should retun 4 elements for Pieces(1 Rook, 2 Kings) and Board(3x3)" in {
    val pieces = List(King, King, Rook)
    val chessBoard = ChessBoard(3, 3)
    chessBoard.getAllUniqueSafeConfigurations(pieces)

    assert(chessBoard.boardUniqueConfiguration.size == 4)
  }

  "Method getAllUniqueSafeConfigurations()" should "should retun 8 elements for Pieces(2 Rook, 2 Knight) and Board (4x4)" in {
    val pieces = List(Knight, Knight, Rook, Rook, Knight, Knight)
    val chessBoard = ChessBoard(4, 4)
    chessBoard.getAllUniqueSafeConfigurations(pieces)

    assert(chessBoard.boardUniqueConfiguration.size == 8)
  }

  "Method getAllUniqueSafeConfigurations()" should "should retun 3063828 elements for Pieces(2, King, 2 Queen, 2 Bishop, Knight) and Board (7x7)" in {
    val pieces = List(King, King, Queen, Queen, Bishop, Bishop, Knight)
    val chessBoard = ChessBoard(7, 7)
    chessBoard.getAllUniqueSafeConfigurations(pieces)

    assert(chessBoard.boardUniqueConfiguration.size == 3063828)
  }
}
