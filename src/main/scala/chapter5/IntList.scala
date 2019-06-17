package chapter5

sealed trait IntList {
  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case IntEnd => end
      case IntPair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def length: Int = fold[Int](0, (head, tail) => 1 + tail)
  def product: Int = fold[Int](1, (head, tail) => head * tail)
  def sum: Int = fold[Int](0, (head, tail) => head + tail)
  def double: IntList =
    fold[IntList](IntEnd, (head, tail) => IntPair(head * 2, tail))
}

case object IntEnd extends IntList
case class IntPair(head: Int, tail: IntList) extends IntList
