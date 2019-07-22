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

      it("allows for the sqrt of expressions") {
        val evaluation = SquareRoot(
          Addition(
            Number(3), Number(1)
          )
        ).eval

        assert(evaluation == Success(2))
      }
    }

    describe("division") {
      it("returns a failure when right side is 0") {
        val evaluation = Division(Number(4), Number(0)).eval

        assert(evaluation == Failure("Division by zero"))
      }

      it("returns result of the division of 2 numbers") {
        val evaluation = Division(Number(5), Number(2)).eval

        assert(evaluation == Success(2.5))
      }

      it("can divide expressions built from additions") {
        val evaluation = Division(
          Addition(Number(3), Number(2)),
          Number(2)
        ).eval

        assert(evaluation == Success(2.5))
      }
    }
  }
}
