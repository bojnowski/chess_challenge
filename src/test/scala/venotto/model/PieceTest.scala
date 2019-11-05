package venotto.model

import org.scalatest._

/*
*Piotr Bojnowski
 */

class PieceTest extends FlatSpec with Matchers {

  "The King object" should "have n moves" in {
    val moves = King.getAllMoves(Square(3, 3), 3, 3)
    assert(moves.size == 4)

    val moves2 = King.getAllMoves(Square(2, 2), 3, 3)
    assert(moves2.size == 9)
  }

  "The Knight object" should "have n moves" in {
    val moves = Knight.getAllMoves(Square(2, 2), 3, 3)
    assert(moves.size == 1)

    val moves2 = King.getAllMoves(Square(3, 3), 5, 5)
    assert(moves2.size == 9)

    val moves3 = Knight.getAllMoves(Square(1, 3), 3, 3)
    assert(moves3.size == 3)
  }

  "The Rook object" should "have n moves" in {
    val moves = Rook.getAllMoves(Square(2, 2), 3, 3)
    assert(moves.size == 5)

    val moves2 = Rook.getAllMoves(Square(3, 3), 3, 3)
    assert(moves2.size == 5)

    val moves3 = Rook.getAllMoves(Square(1, 3), 4, 4)
    assert(moves3.size == 7)
  }

  "The Bishop object" should "have n moves" in {
    val moves = Bishop.getAllMoves(Square(2, 2), 3, 3)
    assert(moves.size == 5)

    val moves2 = Bishop.getAllMoves(Square(3, 3), 3, 3)
    assert(moves2.size == 3)

    val moves3 = Bishop.getAllMoves(Square(1, 3), 4, 4)
    assert(moves3.size == 4)
  }

  "The Queen object" should "have n moves" in {
    val moves = Queen.getAllMoves(Square(2, 2), 3, 3)
    assert(moves.size == 9)

    val moves2 = Queen.getAllMoves(Square(3, 3), 5, 5)
    assert(moves2.size == 17)
  }

}
