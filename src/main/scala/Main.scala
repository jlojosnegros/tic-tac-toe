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
        val (from, to ) = coordinateView.readFromTo(game)
        game = game.move(from, to)
      }
      GameView.write(game)
    } while (!game.isTicTacToe)
    GestorIO.write("... pero has perdido")
  }
}
