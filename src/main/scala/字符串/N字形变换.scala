package 字符串

object N字形变换 {

  def main(args: Array[String]): Unit = {
    println(convert("PAYPALISHIRING",4))
  }

  def convert(s: String, numRows: Int): String = {
    val l = s.length
    if (l <= numRows|| numRows < 2){
      return s
    }
    var result = ""
    for (i <- 0 until (numRows)) {
      var k = i
      while (k < l) {
        result += s(k)
        if (i != 0 && i != numRows - 1) {
          val level = numRows - i - 1
          val next = k + (level + (numRows - 2 - level))+1
          if (next < l) {
            result += s(next)
          }

        }
        k = k + numRows + (numRows - 2)
      }
    }
    result
  }

}
