package chapter5

// Starting with just a string tree
sealed trait Tree[A] {
  def fold[A](joiner: (A, A) => A): A = {
    this match {
      case Leaf(value) => value
      case Node(left, right) => joiner(left.fold(joiner), right.fold(joiner))
    }
  }
}

final case class Leaf[A](value: A) extends Tree[A]
final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
