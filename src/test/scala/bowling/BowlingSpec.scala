package bowling

import org.scalatest._

class BowlingSpec extends FlatSpec with Matchers {

  val roll0 = Roll(0)

  "The Role Object" should "valid All roll with 0 pin down give a score of 0" in {
      roll0.score should be (0)
  }

}
