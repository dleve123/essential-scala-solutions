package chapter5

import org.dleve123.essentialscala.UnitSpec

class SumSpec extends UnitSpec {
  describe("#fold") {
    it("converts to other types with a default value for empty") {
      val something: Sum[Int, String] = Success[Int, String]("testing")

      val folded = something.fold[Boolean](l => l == 0,r => r == "testing")

      assert(folded == true)
    }
  }

  describe("#map") {
    it("converts Successes to be of the new type by applying function") {
      val something: Sum[Int, String] = Success[Int, String]("testing")

      val mapped: Sum[Int, Boolean] = something.map[Boolean](e => e == "testing" )

      assert(mapped == Success[Int, Boolean](true))
    }

    it("converts Failures to be of the new type by passing through value") {
      val something: Sum[Int, String] = Failure[Int, String](0)

      val mapped: Sum[Int, Boolean] = something.map[Boolean](e => e == "testing" )

      assert(mapped == Failure[Int, Boolean](0))
    }
  }

  describe("#flatMap") {
    it("transforms and returns successes") {
      val something = Success[Int, String]("testing")

      val actual = something.flatMap[Boolean](v => Success[Int,Boolean](v == "testing"))

      assert(actual == Success[Int, Boolean](true))
    }

    it("returns a failure") {
      val something = Failure[Int, String](0)

      val actual = something.flatMap[Boolean](e => Success[Int,Boolean](e == "testing"))
      val expected = Failure(0)

      assert(actual == expected)
    }
  }
}
