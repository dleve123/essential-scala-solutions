package chapter5

sealed trait LinkedList[A] {
  def length(): Int = {
    this match {
      case End() => 0
      case Pair(head, tail) => {
        1 + tail.length()
      }
    }
  }

  def contains(thing: A): Boolean = {
    this match {
      case End() => false
      case Pair(head, tail) => {
        if (head == thing) {
          true
        } else {
          tail.contains(thing)
        }
      }
    }
  }

  def apply(index: Int): Result[A] = {
    this match {
      case End() => Failure("Index out of bounds")
      case Pair(head, tail) => {
        if (index == 0) {
          Success(head)
        } else {
          tail.apply(index - 1)
        }
      }
    }
  }
}

final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]