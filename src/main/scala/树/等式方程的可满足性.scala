package 树

/**
 * 力扣 990
 * 描述：给定一个由字符串方程组成的数组 equations，每个字符串方程 equations[i] 的长度为 4，有以下两种形式组成：a==b 或 a!=b。a 和 b 是小写字母，表示单字母变量名。
 * 要求：判断所有的字符串方程是否能同时满足，如果能同时满足，返回 True，否则返回 False。
 *  1≤equations.length≤500。
 *  equations[i].length==4。
 *  equations[i][0] 和equations[i][3] 是小写字母
 *  equations[i][1] 要么是 '='，要么是 '!'
 *  equations[i][2] 是 '='
 *
 *
 * 输入    ["a==b","b!=a"]
 * 输出    False
 * 解释    如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。

 */
object 等式方程的可满足性 {


  /**
   * 解题思路
   * 并查集
   * 将集合中等式两侧的变量合并成一个集合 s
   * 将不等式两侧的变量在s 中进行联通测试，如果可以联通说明不能满足所有条件 返回False
   * 如果所有不等式都不能联通，说明满足所有条件，返回True
   *
   *
   *
   *
   *
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {


  }



}
