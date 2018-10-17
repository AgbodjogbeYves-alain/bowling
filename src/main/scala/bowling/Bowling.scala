package bowling
import scala.annotation.tailrec
import scala.util.Random

object Bowling extends App {

  val randomRoll1 = Random
  val randomRoll2 = Random
  val randomRoll3 = Random

  val gameState = game()

  println("Score : " + gameState.scoreGameState())

  def generateRandomValues(random1: Random, random2: Random, random3: Random): (Int,Int,Int) = {
    return (random1.nextInt(),random2.nextInt,random3.nextInt())
  }


  def game() : GameState = {
    val gameStart = GameState(List())

    @tailrec
    def gameTailRec(gameStateTailRec : GameState,numFrame : Int,random1: Random,random2: Random, random3: Random): GameState = {
      if(numFrame == 11){
        return gameStateTailRec
      }else{
        val nbPinFallRoll1 = random1.nextInt(10)
        if(nbPinFallRoll1 == 10){
          val nbPinFallRoll2 = random2.nextInt(10)
          if(nbPinFallRoll2!=10){
            val nbPinFallRoll3 = random3.nextInt(10 - nbPinFallRoll2)
            val bonus = nbPinFallRoll3+nbPinFallRoll2
            val newRoll = Roll(nbPinFallRoll1,bonus)
            val newFrame = Frame(nbPinFallRoll1,newRoll)
            val newGameTailRec = gameStateTailRec.copy(listFrame = gameStateTailRec.listFrame :+ newFrame)
            gameTailRec(newGameTailRec,numFrame+1,random1,random2,random3)
          }else{
            val nbPinFallRoll3 = random3.nextInt(10)
            val bonus = nbPinFallRoll3+nbPinFallRoll2
            val newRoll = Roll(nbPinFallRoll1,bonus)
            val newFrame = Frame(nbPinFallRoll1,newRoll)
            val newGameTailRec = gameStateTailRec.copy(listFrame = gameStateTailRec.listFrame :+ newFrame)
            gameTailRec(newGameTailRec,numFrame+1,random1,random2,random3)
          }
        }else{
          val newRoll = Roll(nbPinFallRoll1)
          val newRoll2 = Some(Roll(random2.nextInt(10-nbPinFallRoll1)))
          val newFrame = Frame(nbPinFallRoll1,newRoll,newRoll2)
          val newGameTailRec = gameStateTailRec.copy(listFrame = gameStateTailRec.listFrame :+ newFrame)
          gameTailRec(newGameTailRec,numFrame+1,random1,random2,random3)
        }
      }
    }
    gameTailRec(gameStart,1,randomRoll1,randomRoll2,randomRoll3)

  }
}
