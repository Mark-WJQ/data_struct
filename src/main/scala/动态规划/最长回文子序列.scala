package 动态规划

import scala.util.control.Breaks.{break, breakable}

object 最长回文子序列 {

  def main(args: Array[String]): Unit = {

    println(longestPalindromeSubseq("bbbab"))

    println(longestPalindromeSubseq("cbbd"))

  }


  /**
   *  假设最长回文子序列长度 f(i,j)
   *  有
   *  if s(i-1) == s(j+1)
   *    f(i-1,j+1) = f(i,j)+2
   *
   *  else
   *   f(i-1,j+1) = max(f(i,j),f(i-1,j),f(i,j-1))
   *
   *
   *
   *
   *
   *
   * @param s
   * @return
   */
  def longestPalindromeSubseq(s: String): Int = {
    val l = s.length;
    if (l < 2){
      return 1
    }
    var max = 1
    val dp = Array.ofDim[Int](l,l)
    for (i <- 0 until l){
      dp(i)(i) = 1
      if (i < l-1){
        dp(i)(i+1) = 1
        if (s(i) == s(i+1)){
          dp(i)(i+1) = 2
          max = math.max(dp(i)(i+1),max)
        }
      }
    }


    /**
     * 遍历子序列长度'
     */

      for (L <- 2 until (l)) {
        breakable{
        for (i <- 0 until (l)) {
          val j = i + L
          if (j >= l) {
            break
          }
          if (s(i) != s(j)) {
            dp(i)(j) = math.max(math.max(dp(i + 1)(j - 1),dp(i)(j-1)),dp(i+1)(j))
          } else {
            dp(i)(j) = dp(i + 1)(j - 1) + 2
            max = math.max(dp(i)(j),max)

          }
        }
      }
    }
    max
  }

}
