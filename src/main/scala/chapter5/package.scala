
// I might need this? package chapter5

package object chapter5 {
  sealed trait Result[A]

  case class Success[A](result: A) extends Result[A]
  case class Failure[A](result: String) extends Result[A]
}
