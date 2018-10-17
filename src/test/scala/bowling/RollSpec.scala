package bowling

import org.scalatest.{FunSpec, Matchers}

class RollSpec extends FunSpec with Matchers{
  describe("A Roll") {
    it("A roll with 0 pin touched must return 0 has sum") {
      val newRoll = Roll(0,0)
        assert(newRoll.score() == 0)
    }

    it("The score of a roll must be the sum of the pin touched and the bonus ") {
      val newRoll1 = Roll(10,20)
      assert(newRoll1.score() == 30)
    }
  }
}
