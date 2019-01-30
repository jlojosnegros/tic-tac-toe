import models.Game
import views.{GameView, CoordinateView, GestorIO}

//1 poder jugar en modo demo ( 0 jugadores ) o normal ( 2 jugadores como ahora)) -- > traits creo
//2 paralelizar el control de si hay tres en ralla para uno y otro.
//3 Hacer esto con actores
object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {
    GameView.write(game)
    do {
      if (!game.isComplete){
        game = game.put(CoordinateView.read)
      } else {
        game = game.move(CoordinateView.read, CoordinateView.read)
      }
      GameView.write(game)
    } while (!game.isTicTacToe)
    GestorIO.write("... pero has perdido")
  }
}
