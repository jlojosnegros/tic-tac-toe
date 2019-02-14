package actors

import models.Game
import views.{CoordinateTrait, GameView}

class Player(coordinateView : CoordinateTrait) {

  protected def make_movement(game: Game): Game = {
    val game1 = {
      if (!game.isComplete) {
        game.put(coordinateView.read(game))
      } else {
        val (from, to) = coordinateView.readFromTo(game)
        game.move(from, to)
      }
    }
    GameView.write(game1)
    game1
  }
}
