import models.Game
import views.{GameView, GestorIO, WelcomeView}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {
    val coordinateView = WelcomeView.readGameType
    GameView.write(game)
    do {
      if (!game.isComplete){
        game = game.put(coordinateView.read(game))
      } else {
        game = game.move(coordinateView.read(game), coordinateView.read(game))
      }
      GameView.write(game)
    } while (!game.isTicTacToe)
    GestorIO.write("... pero has perdido")
  }
}
