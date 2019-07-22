package chapter5

import org.dleve123.essentialscala.UnitSpec

class CalculatorSpec extends UnitSpec {
  describe("#eval") {
    describe("addition") {
      it("can evaluation the addition of 2 numbers") {
        val evaluation = Addition(Number(1), Number(2)).eval

        assert(evaluation == Success(3))
      }

      it("can evaluate the addition of additions") {
        val evaluation =
        Addition(
          Addition(Number(1),Number(2)),
          Addition(Number(3),Number(4))
        ).eval

        assert(evaluation == Success(10))
      }
    }
    describe("square rooting") {
      it("returns a failure when sqrt-ing negative numbers") {
        val evaluation = SquareRoot(Number(-1)).eval

        assert(evaluation == Failure("square root of negative number"))
      }

      it("returns the sqrt of a non-negative number") {
        val evaluation = SquareRoot(Number(4)).eval

        assert(evaluation == Success(2))
      }
    }

    describe("division") {
      it("returns a failure when right side is 0") {
        val evalution = Division(Number(4), Number(0)).eval

        assert(evalution == Failure("Division by zero"))
      }
      it("returns result of the division of 2 numbers") {
        pending
      }
    }
  }
}
