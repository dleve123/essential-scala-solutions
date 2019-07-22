package chapter5

sealed trait Sum[+A,+B] {
  def fold[C](failure: A => C, success: B => C): C = {
    this match {
      case Failure(value) => failure(value)
      case Success(value) => success(value)
    }
  }

  def map[C](fn: B => C): Sum[A, C] = {
    this match {
      case Success(value) => Success(fn(value))
      case Failure(value) => Failure(value)
    }
  }

  def flatMap[AA >: A, C](fn: B => Sum[AA, C]): Sum[AA, C] = {
    this match {
      case Success(value) => fn(value)
      case Failure(value) => Failure(value)
    }
  }
}

final case class Failure[A](value: A) extends Sum[A,Nothing]
final case class Success[B](value: B) extends Sum[Nothing,B]
