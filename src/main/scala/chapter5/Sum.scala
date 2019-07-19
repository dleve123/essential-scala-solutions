package chapter5

sealed trait Sum[A,B] {
  def fold[C](failure: A => C, success: B => C): C = {
    this match {
      case Failure(value) => failure(value)
      case Success(value) => success(value)
    }
  }

  def map[C](fn: B => C): Sum[A, C] = {
    this match {
      case Success(value) => Success[A,C](fn(value))
      case Failure(value) => Failure[A,C](value)
    }
  }

  def flatMap[C](fn: B => Sum[A,C]): Sum[A,C] = {
    this match {
      case Success(value) => fn(value)
      case Failure(value) => Failure(value)
    }
  }
}

final case class Failure[A,B](value: A) extends Sum[A,B]
final case class Success[A,B](value: B) extends Sum[A,B]
