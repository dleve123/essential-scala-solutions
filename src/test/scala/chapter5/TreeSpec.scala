package chapter5

import org.dleve123.essentialscala.UnitSpec

class TreeSpec extends UnitSpec {
  describe("#fold") {
    it("returns a string representation of a complicated Tree") {
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

      val foldResult = tree.fold[String](leaf => leaf, (left, right) => left + " " + right)
      assert(foldResult == "To iterate is human, to recurse divine")
    }

    it("returns just the leaf (without padding) when the tree is just a leaf") {
      val tree: Tree[String] = Leaf("hi")

      assert(tree.fold[String](leaf => leaf, (left, right) => left + " " + right) == "hi")
    }

    it("proof of concept - can elegantly calculate the number of characters across all nodes") {
      val tree: Tree[String] =
        Node(
          Node(
            Leaf("a"), Leaf("bb")
          ),
          Node(
            Node(
              Leaf("ccc"), Leaf("dddd")
            ),
            Node(
              Leaf("eeeee"),
              Node(
                Leaf("ffffff"),
                Leaf("ggggggg")
              )
            )
          )
        )

      val foldResult = tree.fold[Int](leaf => leaf.size, (left, right) => left + right)
      assert(foldResult == 28)
    }
  }
}
