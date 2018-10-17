package bowling
import org.scalatest.{FunSpec, Matchers}

class GameSpec extends FunSpec with Matchers{
  describe("A Game") {
    it("The empty game must return 0 has sum") {
      val newGame = GameState(List())
      assert(newGame.scoreGameState() == 0)
    }

    it("The score of a game with frames must be the sum of the score of these frames ") {
      val newRoll1 = Roll(5,0)
      val newRoll2 = Roll(5,0)
      val newFrame1 = Frame(1,newRoll1,Some(newRoll2))
      val newGame = GameState(List(newFrame1))
      assert(newGame.scoreGameState() == 10)
    }

    it("The score of a game with 10 frames with 0 pin fall must be 0 ") {
      val newRoll1 = Roll(0,0)
      val newRoll2 = Roll(0,0)
      val newFrame1 = Frame(1,newRoll1,Some(newRoll2))
      val newGame = GameState(List(newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1))

      assert(newGame.scoreGameState() == 0)
    }

    it("The score of a game with 10 frame with 10 pin fall for each rolls must be 300 ") {
      val newRoll1 = Roll(10,20)
      val newFrame1 = Frame(1,newRoll1)
      val newGame = GameState(List(newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1,newFrame1))

      assert(newGame.scoreGameState() == 300)
    }
  }
}
