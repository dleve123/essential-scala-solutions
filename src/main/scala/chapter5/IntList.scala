package chapter5

sealed trait IntList {

  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case IntEnd => end
      case IntPair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def length: Int = fold(0, (head, tail) => 1 + tail)

  def double: IntList =
    this match {
      case IntEnd => IntEnd
      case IntPair(hd, tl) => IntPair(hd * 2, tl.double)
    }

  def product: Int = fold(1, (head, tail) => head * tail)

  def sum: Int = fold(0, (head, tail) => head + tail)
}

case object IntEnd extends IntList
case class IntPair(head: Int, tail: IntList) extends IntList
