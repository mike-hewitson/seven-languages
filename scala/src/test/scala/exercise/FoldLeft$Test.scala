package exercise

import org.scalatest.FunSuite

class FoldLeft$Test extends FunSuite {

  test("testCompute") {
    assert(15==ListCount.compute())
  }

}
