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
}
