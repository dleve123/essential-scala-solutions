package chapter5

sealed trait Expression {
  def eval: Sum[String, Double] = {
    this match {
      case Addition(left: Number, right: Number) => {
        Success(left.value + right.value)
      }
      case SquareRoot(number: Number) => {
        if(number.value < 0) {
         Failure("square root of negative number")
        } else {
         Success(Math.sqrt(number.value))
        }
      }
    }
  }
}

final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class SquareRoot(value: Expression) extends Expression
final case class Number(value: Double) extends Expression
