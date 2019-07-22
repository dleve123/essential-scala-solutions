package chapter5

sealed trait Expression {
  def eval: Sum[String, Double] = {
    this match {
      case Addition(left: Expression, right: Expression) => {
        left.eval.flatMap( l =>
          right.eval.flatMap( r =>
            Success(l+r)
          )
        )
      }
      case SquareRoot(number: Number) => {
        if(number.value < 0) {
         Failure("square root of negative number")
        } else {
         Success(Math.sqrt(number.value))
        }
      }
      case Division(left: Number, right: Number) => {
       if (right.value == 0) {
         Failure("Division by zero")
       } else {
         Success(left.value / right.value)
       }
      }
      case Number(value) => Success(value)
    }
  }
}

final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class SquareRoot(value: Expression) extends Expression
final case class Number(value: Double) extends Expression
