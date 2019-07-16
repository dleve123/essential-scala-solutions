package chapter5

import org.dleve123.essentialscala.UnitSpec

class MaybeSpec extends UnitSpec {
  describe("#fold") {
    it("converts to other types with a default value for empty") {
      val perhaps: Maybe[String] = Full[String]("four")

      val folded = perhaps.fold[Int](v => v.size, 0)

      assert(folded == 4)
    }
  }

  describe("#map") {
    it("transforms Fulls according to the transformation function") {
      val perhaps: Maybe[String] = Full[String]("four")

      val actual: Maybe[Int] = perhaps.map( _.length )

      assert(actual == Full[Int](4))
    }

    it("creates empties of the new type") {
      val notActually: Maybe[String] = Empty()

      val actual: Maybe[Int] = notActually.map( _.length )

      assert(actual == Empty[Int]())
    }
  }
}
