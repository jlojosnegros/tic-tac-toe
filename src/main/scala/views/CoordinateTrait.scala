package views

import models.{Coordinate, Game}

trait CoordinateTrait {

  def read(currentPosition: Game ): Coordinate

  def readFromTo(currentPosition: Game) : (Coordinate, Coordinate)
}
