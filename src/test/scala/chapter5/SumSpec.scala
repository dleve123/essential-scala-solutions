package chapter5

import org.dleve123.essentialscala.UnitSpec

class SumSpec extends UnitSpec {
  describe("#fold") {
    it("converts to other types with a default value for empty") {
      val something: Sum[Int, String] = Success[String]("testing")

      val folded = something.fold[Boolean](l => l == 0,r => r == "testing")

      assert(folded == true)
    }
  }

  describe("#map") {
    it("converts Successes to be of the new type by applying function") {
      val something: Sum[Int, String] = Success[String]("testing")

      val mapped: Sum[Int, Boolean] = something.map[Boolean](_ == "testing")

      assert(mapped == Success[Boolean](true))
    }

    it("converts Failures to be of the new type by passing through value") {
      val something: Sum[Int, String] = Failure[Int](0)

      val mapped: Sum[Int, Boolean] = something.map[Boolean](_ == "testing" )

      assert(mapped == Failure[Int](0))
    }
  }

  describe("#flatMap") {
    it("transforms and returns successes") {
      val something = Success[String]("testing")

      val actual = something.flatMap[String, Boolean](v => Success(v == "testing"))
      val actual2 = something.map[Boolean](v => v == "testing")

      assert(actual == Success[Boolean](true))
    }

    it("returns a failure") {
      val something = Failure[Int](0)

      val actual = something.flatMap[Int, Boolean](e => Success[Boolean](e == "testing"))
      val expected = Failure(0)

      assert(actual == expected)
    }
  }
}
