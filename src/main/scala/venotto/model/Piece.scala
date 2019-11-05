package venotto.model
/*
*Piotr Bojnowski
 */
trait Piece {
  val name: String
  val priority: Int

  def getAllMoves(position: Square, sizeX: Int, sizeY: Int): Set[Square]
  override def toString: String = name
}

object Queen extends Piece{
  override val name: String = "Q"
  override val priority: Int = 1

  override def getAllMoves(position: Square, sizeX: Int, sizeY: Int): Set[Square] = {
    var result = Set(position)
    val size = math.max(sizeX, sizeY)

    for(i <- -size to size){
      val x = position.x + i
      val y = position.y + i

      if (x > 0 && x <= sizeX && y > 0 && y <= sizeY)result += Square(x,y)
    }

    for(i <- 1 to size){
      val x = position.x + i
      val y = position.y - i

      val a = position.x - i
      val b = position.y + i

      if (x > 0 && x <= sizeX && y > 0 && y <= sizeY) result += Square(x,y)
      if (a > 0 && a <= sizeX && b > 0 && b <= sizeY) result += Square(a,b)
    }

    val coordinates = for {
      x <- (position.x - sizeX to position.x + sizeX)
      y <- (position.y - sizeY to position.y + sizeY)
      if x > 0 && x <= sizeX && y > 0 && y <= sizeY
    } yield (x, y)

    coordinates.foreach(xy => result += Square(position.x, xy._2))
    coordinates.foreach(xy => result += Square(xy._1, position.y))
    result
  }
}

object Rook extends Piece{
  override val name: String = "R"
  override val priority: Int = 2

  override def getAllMoves(position: Square, sizeX: Int, sizeY: Int): Set[Square] = {
    var result = Set(position)
    val coordinates = for {
      x <- (position.x - sizeX to position.x + sizeX)
      y <- (position.y - sizeY to position.y + sizeY)
      if x > 0 && x <= sizeX && y > 0 && y <= sizeY
    } yield (x, y)
    coordinates.foreach(xy => result += Square(position.x, xy._2))
    coordinates.foreach(xy => result += Square(xy._1, position.y))
    result
  }
}

object Bishop extends Piece{
  override val name: String = "B"
  override val priority: Int = 3

  override def getAllMoves(position: Square, sizeX: Int, sizeY: Int): Set[Square] = {
    var result = Set(position)
    val size = math.max(sizeX, sizeY)

    for(i <- -size to size){
      val x = position.x + i
      val y = position.y + i

      if (x > 0 && x <= sizeX && y > 0 && y <= sizeY)result += Square(x,y)
    }
    for(i <- 1 to size){
      val x = position.x + i
      val y = position.y - i

      val a = position.x - i
      val b = position.y + i

      if (x > 0 && x <= sizeX && y > 0 && y <= sizeY)result += Square(x,y)
      if (a > 0 && a <= sizeX && b > 0 && b <= sizeY)result += Square(a,b)
    }
    result
  }
}

object King extends Piece{
  override val name: String = "K"
  override val priority: Int = 4

  override def getAllMoves(position: Square, sizeX: Int, sizeY: Int): Set[Square] = {
    var result = Set(position)
    val coordinates = for {
      x <- (position.x - 1 to position.x + 1)
      y <- (position.y - 1 to position.y + 1)
      if x > 0 && x <= sizeX && y > 0 && y <= sizeY
    } yield (x, y)
    coordinates.foreach(xy => result += Square(xy._1, xy._2))
    result
  }
}

object Knight extends Piece{
  override val name: String = "C"
  override val priority: Int = 5

  override def getAllMoves(position: Square, sizeX: Int, sizeY: Int): Set[Square] = {
    var result = Set(position)
    val availableSquare: List[Tuple2[Int, Int]] = List((-2,-1), (2,-1), (-1, -2), (1,-2), (-2,1), (-1,2), (2,1), (1,2))

    availableSquare.foreach(av => {
      val x = position.x + av._1
      val y = position.y + av._2
      if(x > 0 && x <= sizeX && y > 0 && y <= sizeY) result += Square(x,y)
    })
    result
  }
}
