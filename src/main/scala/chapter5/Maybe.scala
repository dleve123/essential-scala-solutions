package chapter5

sealed trait Maybe[A] {
  def fold[B](full: A => B, empty: B): B = {
   this match {
     case Full(value) => full(value)
     case Empty() => empty
    }
  }

  def flatMap[B](fn: A => Maybe[B]): Maybe[B] = {
    this match {
      case Full(value) => fn(value)
      case Empty() => Empty[B]()
    }
  }

  def map[B](fn: A => B): Maybe[B] = {
    this match {
      case Full(value) => Full(fn(value))
      case Empty() => Empty()
    }
  }
}

case class Full[A](value: A) extends Maybe[A]
case class Empty[A]() extends Maybe[A]

