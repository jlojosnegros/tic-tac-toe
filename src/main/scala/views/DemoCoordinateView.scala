package views
import models.{Coordinate, Game}

import scala.util.Random

object DemoCoordinateView extends CoordinateTrait {

  val generator: Random = new scala.util.Random(System.currentTimeMillis())

  override def read(currentPosition: Game): Coordinate = {
    def generate: Coordinate = {
      val (row, col) = (generator.nextInt(3), generator.nextInt(3))
      currentPosition.canMoveTo(new Coordinate(row, col)) match {
        case true => new Coordinate(row, col)
        case false => generate
      }
    }
    generate
  }
}

