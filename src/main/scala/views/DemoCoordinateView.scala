package views
import models.{Coordinate, Game}

import scala.util.Random

object DemoCoordinateView extends CoordinateTrait {

  val generator: Random = new scala.util.Random(System.currentTimeMillis())

  def generate_ (currentPosition: Game) : Coordinate = {
    val (row, col) = (generator.nextInt(3), generator.nextInt(3))
    currentPosition.canMoveTo(new Coordinate(row, col)) match {
      case true => new Coordinate(row, col)
      case false => generate_(currentPosition)
    }
  }

  def generate2_(currentPosition: Game) : Coordinate = {
    val (row, col) = (generator.nextInt(3), generator.nextInt(3))
    currentPosition.canMoveFrom(new Coordinate(row, col)) match {
      case true => new Coordinate(row, col)
      case false => generate2_(currentPosition)
    }
  }
  override def read(currentPosition: Game): Coordinate = {
    generate_(currentPosition)
  }

  override def readFromTo(currentPosition: Game): (Coordinate, Coordinate) = {
    (generate2_(currentPosition), generate_(currentPosition))
  }
}

