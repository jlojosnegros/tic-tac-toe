package actors

import models.Game

case class YourTurn(game: Game)
case class StartMessage(game: Game)
case object IsTicTacToeMessage
