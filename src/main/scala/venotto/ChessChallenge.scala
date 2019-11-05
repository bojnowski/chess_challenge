package venotto

import venotto.model._

/*
*Piotr Bojnowski
 */

object ChessChallenge extends Welcome with App {
  println(welcome)
  val t0 = System.nanoTime()

  val pieces = List(King, King, Queen, Queen, Bishop, Bishop, Knight)
  val chessBoard = ChessBoard(7,7)
  chessBoard.getAllUniqueSafeConfigurations(pieces)
  val t1 = System.nanoTime()

  println("\nTime: " + (t1 - t0)/ 1000000000.0 + " s")
  println(chessBoard)
}

trait Welcome {
  lazy val welcome: String =
    """Chess Challenge
      |---------------------------------------
    """.stripMargin
}
