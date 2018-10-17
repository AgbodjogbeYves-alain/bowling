package bowling

case class GameState(listFrame: List[Frame]) {
  def scoreGameState(): Int = {
    val somme = listFrame.foldLeft(0){(acc,frame) => acc+frame.calculScore()}
    return somme
  }
}

