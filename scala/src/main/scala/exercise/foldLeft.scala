package exercise

class FoldLeft

  object ListCount {
    val list = List("This", "is", "just", "a", "test")

    def compute(): Int = {
      return list.foldLeft(0)((sum, value) => sum + value.length)
    }
  }

  /*def main(args: Array[String]) {
    ListCount.compute()
  }*/
