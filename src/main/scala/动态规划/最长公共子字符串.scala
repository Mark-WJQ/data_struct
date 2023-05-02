package 动态规划

import scala.math

object 最长公共子字符串 {


  def main(args: Array[String]): Unit = {

  }


  def longestCommonSubsequence(text1: String, text2: String): Int = {
    var l1 = text1.length
    var l2 = text2.length

    var r= Array.ofDim[Int](l1+1, l2+1)
    for (i <- 1 to l1) {
      for (j <- 1 to l2) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          r(i)(j) = r(i - 1)(j - 1) + 1
        } else {
          r(i)(j) = math.max(r(i - 1)(j), r(i)(j - 1))
        }
      }
    }
    r(l1)(l2)
  }

}
