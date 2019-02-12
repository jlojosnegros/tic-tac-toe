package views
import models.{Coordinate, Game}

import scala.util.Random

object DemoCoordinateView extends CoordinateTrait {

  val generator: Random = new scala.util.Random(System.currentTimeMillis())

  def generateRandomCoordinate_ : Coordinate = new Coordinate(generator.nextInt(3), generator.nextInt(3))

  def generateCoordinateToMoveTo_(currentPosition: Game) : Coordinate = {
    val tryingToMoveTo = generateRandomCoordinate_
    currentPosition.canMoveTo(tryingToMoveTo) match {
      case true => tryingToMoveTo
      case false => generateCoordinateToMoveTo_(currentPosition)
    }
  }

  def generateCoordinateToMoveFrom_(currentPosition: Game) : Coordinate = {
    val tryingToMoveFrom = generateRandomCoordinate_
    currentPosition.canMoveFrom(tryingToMoveFrom) match {
      case true => tryingToMoveFrom
      case false => generateCoordinateToMoveFrom_(currentPosition)
    }
  }
  override def read(currentPosition: Game): Coordinate = {
    generateCoordinateToMoveTo_(currentPosition)
  }

  override def readFromTo(currentPosition: Game): (Coordinate, Coordinate) = {
    (generateCoordinateToMoveFrom_(currentPosition), generateCoordinateToMoveTo_(currentPosition))
  }
}

