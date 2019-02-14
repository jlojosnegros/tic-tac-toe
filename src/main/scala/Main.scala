import actors.{OPlayer, StartMessage, XPlayer}
import models.Game
import views.{GameView, GestorIO, WelcomeView}
import akka.actor.{ActorSystem, Props}

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

object TicTacToe extends App {
  val system = ActorSystem("system")

  val coordinateView = WelcomeView.readGameType

  val oPlayer = system.actorOf(Props(new OPlayer(coordinateView)), name = "O")
  val xPlayer = system.actorOf(Props(new XPlayer(oPlayer,coordinateView)), name = "X")

  var game = new Game

  GameView.write(game)

  xPlayer ! StartMessage(game)
}