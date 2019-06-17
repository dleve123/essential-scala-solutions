package chapter5

sealed trait Tree[A] {
  def fold[B](leaf: A => B, node: (B, B) => B): B = {
    this match {
      case Leaf(value) => leaf(value)
      case Node(left, right) => node(left.fold(leaf, node), right.fold(leaf, node))
    }
  }
}

final case class Leaf[A](value: A) extends Tree[A]
final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
