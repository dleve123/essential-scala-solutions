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

  describe("#map") {
    it("converts Rights to be of the new type by applying function") {
      val something: Sum[Int, String] = Right[Int, String]("testing")

      val mapped: Sum[Int, Boolean] = something.map[Boolean](e => e == "testing" )

      assert(mapped == Right[Int, Boolean](true))
    }

    it("converts Lefts to be of the new type by passing through value") {
      val something: Sum[Int, String] = Left[Int, String](0)

      val mapped: Sum[Int, Boolean] = something.map[Boolean](e => e == "testing" )

      assert(mapped == Left[Int, Boolean](0))
    }
  }
}
