package actors

import akka.actor.{Actor, ActorRef}
import views.{CoordinateTrait, GestorIO}

class XPlayer(oPlayer: ActorRef,  coordinateView : CoordinateTrait ) extends Player(coordinateView) with Actor {
  override def receive: Receive = {
    case StartMessage(game) => {
      GestorIO.write("XPlayer: Que comience el juego!\n")
      val newGame = make_movement(game)
      oPlayer ! YourTurn(newGame)
    }

    case YourTurn(game) => {
      GestorIO.write("XPlayer: mi turno\n")
      val newGame = make_movement(game)

      if (newGame.isTicTacToe) {
        GestorIO.write("XPlayer: gane!\n")
        sender ! IsTicTacToeMessage
        println("terminando xplayer...")
        context.stop(self)
      } else {
        sender ! YourTurn(newGame)
      }
    }

    case IsTicTacToeMessage => {
      GestorIO.write("XPlayer: he perdido\n")
      context.stop(self)
      println("terminado xplayer perdiendo")
    }
  }
}
