package views

import models.Game

object GameView {

  def write(game:Game) = {
    TurnView.write(game)
    BoardView.write(game)
  }
}
