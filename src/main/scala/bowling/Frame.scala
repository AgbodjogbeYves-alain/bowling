package bowling

case class Frame(numeroFrame: Int,roll1: Roll,roll2: Option[Roll] = None) {
  def calculScore(): Int = {
    if(roll2.isEmpty){
      roll1.score()
    }else{
      val somme = roll1.score() + roll2.get.score()
      return somme
    }
  }
}
