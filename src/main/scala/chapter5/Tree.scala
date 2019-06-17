package chapter5

// Starting with just a string tree
sealed trait Tree {
  def fold: String = {
    this match {
      case Leaf(value) => value
      case Node(left, right) => left.fold + " " + right.fold
    }
  }
}

final case class Leaf(value: String) extends Tree
final case class Node(left: Tree, right: Tree) extends Tree
