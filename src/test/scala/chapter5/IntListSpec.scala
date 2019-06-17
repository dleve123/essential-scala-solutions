package chapter5

import org.dleve123.essentialscala.UnitSpec

class IntListSpec extends UnitSpec {
  describe("#sum") {
    it("returns the arithmetic sum of the elements of the List") {
      val example = IntPair(1, IntPair(2, IntPair(3, IntEnd)))

      assert(example.sum == 6)
    }

    it("returns 0 when there is just an empty List") {
      val example = IntEnd

      assert(example.sum == 0)
    }
  }
}
