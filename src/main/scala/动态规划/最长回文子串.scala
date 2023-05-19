package 动态规划

object 最长回文子串 {

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("babad"))

  }


  /**
   *
   *  状态是 字符串的起点i与终点j P(i,j)
   *  状态转移方程
   *  当 P(i,j) 是回文串时，当s(i-1) == s(j+1), P(i-1,j+1) 是回文串
   *  当j-i =1 且 s(i) == s(j) 时，P(i,j) 是回文串
   *  初始状态P(i,i) = 1 是回文串
   *
   *
   *
   *
   * @param s
   * @return
   */
  def longestPalindrome(s: String): String = {
    val l = s.length
    if (l==0){
      return ""
    }
    val nums = Array.ofDim[Int](l,l)
    var max = 1
    var pos = 0
    var end = 0

    for (i <- 0 until(l)){
      nums(i)(i) = 1
    }
    for (i <- l-2 to 0 by(-1)){
      for (j <- i+1 until l) {
        if ((j-i == 1 || nums(i+1)(j-1) ==1) && s(i)==s(j))
          nums(i)(j) = 1
          if (j-i+1 > max){
            max = j-i+1
            pos = i
            end = j
          }
      }
    }
    s.substring(pos,end+1)
  }

}
