package chapter5

import org.dleve123.essentialscala.UnitSpec

class SumSpec extends UnitSpec {
  describe("#fold") {
    it("converts to other types with a default value for empty") {
      val something: Sum[Int, String] = Right[Int, String]("testing")

      val folded = something.fold[Boolean](l => l == 0,r => r == "testing")

      assert(folded == true)
    }
  }
}
