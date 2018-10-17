package bowling

case class Roll(nbPinTouched: Int = 0,bonus: Int = 0) {
  def score(): Int ={
    return nbPinTouched + bonus
  }

}
