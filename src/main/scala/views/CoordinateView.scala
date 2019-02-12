package views

import models.{Coordinate, Game}

object CoordinateView extends CoordinateTrait {

  override def read(currentPosition: Game): Coordinate = {
      val row = GestorIO.readInt("Fila? [1-3]")
      val column = GestorIO.readInt("Columna? [1-3]")
      new Coordinate(row-1, column-1)
    }
}
