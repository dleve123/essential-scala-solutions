package chapter5

sealed trait Sum[A,B] {

  def map[C](fn: B => C): Sum[A, C] = {
    this match {
      case Right(value) => Right[A,C](fn(value))
      case Left(value) => Left[A,C](value)
    }
  }
  def fold[C](left: A => C, right: B => C): C = {
    this match {
      case Left(value) => left(value)
      case Right(value) => right(value)
    }
  }
}

final case class Left[A,B](value: A) extends Sum[A,B]
final case class Right[A,B](value: B) extends Sum[A,B]
