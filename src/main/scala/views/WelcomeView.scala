package views

object WelcomeView {

  def readGameType: CoordinateTrait = {
    GestorIO.write("Welcome to tic-tac-toe:\n")
    GestorIO.write("\t Choose your game mode:\n")
    GestorIO.write("\t\t1 => Human vs Human.\n")
    GestorIO.write("\t\t2 => CPU vs CPU.\n")
    GestorIO.readInt("Choose Option [1]: ") match {
      case 2 => DemoCoordinateView
      case _ => CoordinateView
    }
  }
}
