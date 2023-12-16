package 双指针



/**
 * 力扣 3
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
object 无重复字符的最长子串 {


  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("aabaab!bb"))

    println(lengthOfLongestSubstring("qwwertt"))

    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("aa"))
    println(lengthOfLongestSubstring("pwwkew"))







  }


  /**
   * 双指正，滑动窗口
   *
   * 1. 使用一个窗口标识无重复字符的字符串，初始化为0，右指针向右移动，直到窗口中有重复字符；左指针向右移动，直到窗口中没有重复字符
   * 2. 如何判断窗口中是否有重复字符，使用一个hashmap 来存储当前窗口中的字符
   * 3. 如何找出最长，使用一个长度标识来记录到目前最长的长度，每次右指针向右移动或左指针向右移动到没有重复字符时比较记录
   *
   *
   *
   *
   *
   *
   * @param s
   * @return
   */
  def lengthOfLongestSubstring(s: String): Int = {
    if (s.length < 2){
      return s.length
    }
    var maxl = 0
    //左右指针之间的元素是不重复的最长子串
    var left,right = 0
    var dict = Set[Char]()
    while (right < s.length){
     val cur =  s.charAt(right)
      if(dict.contains(cur)){
        while (s.charAt(left) != cur){
          dict = dict.-(s.charAt(left))
          left +=1
        }
      }
      dict = dict.+(cur)
      right+=1
      maxl = math.max(maxl,dict.size);
    }
    maxl
  }


}
