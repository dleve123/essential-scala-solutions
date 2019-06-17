package chapter5

import org.dleve123.essentialscala.UnitSpec

class TreeSpec extends UnitSpec {
  describe("#fold") {
    it("returns a string representation of a Tree") {
      val tree: Tree[String] =
        Node(
          Node(
            Leaf("To"), Leaf("iterate")
          ),
          Node(
            Node(
             Leaf("is"), Leaf("human,")
            ),
            Node(
              Leaf("to"),
              Node(
                Leaf("recurse"),
                Leaf("divine")
              )
            )
          )
        )

      assert(tree.fold((left: String, right: String) => left + " " + right) == "To iterate is human, to recurse divine")
    }
  }
}
