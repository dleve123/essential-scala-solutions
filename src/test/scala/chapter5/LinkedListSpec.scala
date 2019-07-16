package chapter5

import org.dleve123.essentialscala.UnitSpec

class LinkedListSpec extends UnitSpec {
  describe("#length") {
    it("returns the number of elements in the LinkedList") {
      val example = Pair(1, Pair(2, Pair(3, End())))

      assert(example.length() == 3)
    }
  }

  describe("#contains") {
    describe("a non-empty LinkedList") {
      it("returns true when the element is contained in the LinkedList") {
        val example = Pair(1, Pair(2, Pair(3, End())))

        assert(example.contains(3) == true)
      }

      it("returns false when the element is not contained in the LinkedList") {
        val example = Pair(1, Pair(2, Pair(3, End())))

        assert(example.contains(4) == false)
      }
    }

    describe("an empty LinkedList") {
      it("always returns false") {
        assert(End().contains(0) == false)
      }
    }
  }

  describe("#apply - ()") {
    it("returns Success for the element at the index (0 indexed)") {
      val example = Pair(1, Pair(2, Pair(3, End())))

      assert(example(0) == Success(1))
      assert(example(1) == Success(2))
      assert(example(2) == Success(3))
    }

    it("returns a Failure when the LinkedList doesn't have an element at the index") {
      val example = Pair(1, Pair(2, Pair(3, End())))

      assert(example(3) == Failure("Index out of bounds"))
    }
  }

  describe("maps") {
    it("can map stuff") {
      val example: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))

      val actual = example.map( _ * 2)

      assert(actual == Pair(2, Pair(4, Pair(6, End()))))
    }
  }
}
