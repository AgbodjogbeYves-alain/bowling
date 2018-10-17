package bowling
import org.scalatest.{FunSpec, Matchers}

class FrameSpec extends FunSpec with Matchers{
  describe("A Frame") {
    it("The score of a frame ") {
      val newRoll1 = Roll(5,0)
      val newRoll2 = Roll(5,0)

      val newFrame = Frame(1,newRoll1,Some(newRoll2))
      assert(newFrame.calculScore() == 10)
    }

    it("The score of a frame with 0 pin fall must be 0 ") {
      val newRoll1 = Roll(0,0)
      val newRoll2 = Roll(0,0)
      val newFrame1 = Frame(1,newRoll1,Some(newRoll2))
      assert(newFrame1.calculScore() == 0)
    }

    it("The score of a frame with 10 pin fall for each rolls must be 30 ") {
      val newRoll1 = Roll(10,20)
      val newFrame1 = Frame(1,newRoll1)

      assert(newFrame1.calculScore() == 30)
    }
  }
}
