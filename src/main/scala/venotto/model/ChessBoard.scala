package venotto.model

import scala.annotation.tailrec
import scala.collection.immutable.HashSet

/*
*Piotr Bojnowski
 */
case class Square(x: Int, y: Int)

case class ChessBoard(val sizeX: Int, val sizeY: Int) {
  var boardUniqueConfiguration: HashSet[Map[Square, Piece]] = HashSet[Map[Square, Piece]]()
  val squares = fillBoard.toSet

  def getAllUniqueSafeConfigurations(pieces: List[Piece]): Unit ={
    val firstElement :: elementsToCheck = pieces.sortBy(_.priority)

    @tailrec
    def getAllStartOptions(squaresForCheck: Set[Square]): Unit ={
      val sq  = squaresForCheck.head
      val elements  = squaresForCheck.tail

      val position = Map(sq -> firstElement)
      val emptySq = squares -- firstElement.getAllMoves(sq, sizeX, sizeY)

      check(elementsToCheck, emptySq, position, pieces.size)

      if(!elements.isEmpty) getAllStartOptions( elements)
    }

    getAllStartOptions(squares)
  }

  private def check(pieces: List[Piece], squaresEm: Set[Square], position: Map[Square, Piece], numberOfPieces: Int): Unit = {
    val pieceToCheck :: elementsToCheck = pieces

    @tailrec
    def getAllSquaresOptions(squaresForCheck: Set[Square], allSquares: Set[Square]): Unit = {
      val sq = squaresForCheck.head
      val elements = squaresForCheck.tail


      val movesForPiece = pieceToCheck.getAllMoves(sq, sizeX, sizeY)
      val emptySq = allSquares -- movesForPiece

      if (shouldAdd(position, movesForPiece) && (emptySq.size >= elementsToCheck.size)) {
        val newPosition = position + (sq -> pieceToCheck)

        if (newPosition.size == numberOfPieces) {
          boardUniqueConfiguration += newPosition
        }
        else{
          check(elementsToCheck, emptySq, newPosition, numberOfPieces)
        }
      }
      if (!elements.isEmpty) getAllSquaresOptions(elements, allSquares)
    }
    if(!squaresEm.isEmpty) getAllSquaresOptions(squaresEm, squaresEm)
  }

  private def shouldAdd(position: Map[Square, Piece], moves: Set[Square]): Boolean ={
    if(!moves.exists(position.keySet)) true else false
  }

  private def fillBoard = for {
      x <- (1 to sizeX)
      y <- (1 to sizeY)
    } yield Square(x,y)

  override def toString: String = "The number of unique combinations: %d \n\n".format(boardUniqueConfiguration.size)
}
