package chapter5

sealed trait IntList {

  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case IntEnd => end
      case IntPair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def length: Int =
    this match {
      case IntEnd => 0
      case IntPair(hd, tl) => 1 + tl.length
    }

  def double: IntList =
    this match {
      case IntEnd => IntEnd
      case IntPair(hd, tl) => IntPair(hd * 2, tl.double)
    }

  def product: Int =
    this match {
      case IntEnd => 1
      case IntPair(hd, tl) => hd * tl.product
    }

  def sum: Int = fold(0, (x: Int, y: Int) => x + y)
}

case object IntEnd extends IntList
case class IntPair(head: Int, tail: IntList) extends IntList
