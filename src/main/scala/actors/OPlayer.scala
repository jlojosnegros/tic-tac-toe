package actors

import akka.actor.Actor
import views.{CoordinateTrait, GestorIO}

class OPlayer(coordinateView: CoordinateTrait ) extends Player(coordinateView) with Actor {
  override def receive: Receive = {
    case YourTurn(game) => {
      GestorIO.write("OPlayer: mi turno\n")
      val newGame = make_movement(game)

      if (newGame.isTicTacToe) {
        GestorIO.write("OPlayer: gane!\n")
        sender ! IsTicTacToeMessage
        context.system.terminate()
      } else {
        sender ! YourTurn(newGame)
      }
    }
    case IsTicTacToeMessage => {
      GestorIO.write("OPlayer: he perdido\n")
      context.system.terminate()
    }
  }
}