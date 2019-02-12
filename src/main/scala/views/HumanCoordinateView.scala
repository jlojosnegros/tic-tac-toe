package views

import models.{Coordinate, Game}

object HumanCoordinateView extends CoordinateTrait {

  override def read(currentPosition: Game): Coordinate =  generateCoordinateToMoveTo_(currentPosition)


  override def readFromTo(currentPosition: Game): (Coordinate, Coordinate) = {
    GestorIO.write("from:\n")
    val from = generateCoordinateToMoveFrom_(currentPosition)
    GestorIO.write("to:\n")
    val to = generateCoordinateToMoveTo_(currentPosition)

    (from, to)
  }



  def generateCoordinate_ : Coordinate = {
    val row = GestorIO.readInt("Fila? [1-3]")
    val column = GestorIO.readInt("Columna? [1-3]")
    new Coordinate(row-1, column-1)
  }

  def generateCoordinateToMoveTo_(currentPosition: Game) : Coordinate = {
    val tryingToMoveTo = generateCoordinate_
    currentPosition.canMoveTo(tryingToMoveTo) match {
      case true => tryingToMoveTo
      case false => {
        GestorIO.write("error: try it again -> ")
        generateCoordinateToMoveTo_(currentPosition)
      }
    }
  }

  def generateCoordinateToMoveFrom_(currentPosition: Game) : Coordinate = {
    val tryingToMoveFrom = generateCoordinate_
    currentPosition.canMoveFrom(tryingToMoveFrom) match {
      case true => tryingToMoveFrom
      case false => {
        GestorIO.write("error: try it again -> ")
        generateCoordinateToMoveFrom_(currentPosition)
      }
    }
  }
}
