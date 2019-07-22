package chapter5

sealed trait Expression {
  def eval: Sum[String, Double] = {
    this match {
      case Addition(left, right) => {
        resolveExpression(left, right, { _ + _ })
      }
      case Subtraction(left, right) => {
        resolveExpression(left, right, { _ - _})
      }
      case SquareRoot(expression) => {
        expression.eval flatMap { e =>
          if(e < 0) {
            Failure("square root of negative number")
          } else {
            Success(Math.sqrt(e))
          }
        }
      }
      case Division(left, right) => {
        left.eval flatMap { l =>
          right.eval flatMap { r =>
            if (r == 0) {
              Failure("Division by zero")
            } else {
              Success(l / r)
            }
          }
        }
      }
      case Number(value) => Success(value)
    }
  }

  def resolveExpression(
    left: Expression,
    right: Expression,
    fn: (Double, Double) => Double
  ): Sum[String, Double] = {
    left.eval.flatMap { l =>
      right.eval.flatMap { r =>
        Success(
          fn(l, r)
        )
      }
    }
  }
}

final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class SquareRoot(value: Expression) extends Expression
final case class Number(value: Double) extends Expression
