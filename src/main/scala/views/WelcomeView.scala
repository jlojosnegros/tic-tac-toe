package views

object WelcomeView {

  def readGameType: CoordinateTrait = {
    GestorIO.write("Welcome to tic-tac-toe:\n")
    GestorIO.write("\t Choose your game mode:\n")
    GestorIO.write("\t\t1 => Human vs Human.\n")
    GestorIO.write("\t\t2 => CPU vs CPU.\n")
    GestorIO.readInt("Choose Option: ") match {
      case 1 => HumanCoordinateView
      case 2 => DemoCoordinateView
      case _ => {
        GestorIO.write("\n\nEntrada erronea, Intentelo de nuevo\n\n");
        readGameType
      }
    }
  }
}
