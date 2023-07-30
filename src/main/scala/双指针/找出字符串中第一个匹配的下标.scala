package 双指针

import scala.util.control.Breaks.{break, breakable}

object 找出字符串中第一个匹配的下标 {
  def main(args: Array[String]): Unit = {
      println(strStr("sadbutsad","sad"))
      println(strStr("leetcode","leeto"))

    println(strStr("leeto","leetcode"))
    println(strStr("a","a"))

    println(strStr("abc","c"))
    println(strStr("mississippi","issip"))



    // println(getNext("abcdefabc").toList)
    println(getNext("aaa").toList)
    println(getNext("leeto").toList)
    //[l,e,e,t,o]
    //[-1,0,0,0,0]

    println(strStrKMP("sadbutsad","sad"))
    println(strStrKMP("leetcode","leeto"))
    println(strStrKMP("a","a"))
    println(strStrKMP("abc","c"))

    println(strStrKMP("mississippi","issip"))





  }


  /**
   * 最直接的办法，双指针
   * f,s
   *
   * 当f 指向的字母与needle 的首字母相同时，second 开始比较后续的字母是否相同
   * 如果能够比较到beedle最后 则找到第一个匹配的下标f
   * 否则 f = f+1
   * 重新开始比较
   *
   *
   *
   * @param haystack
   * @param needle
   * @return
   */
  def strStr(haystack: String, needle: String): Int = {
    val hl = haystack.length
    val nl = needle.length
    if (nl > hl){
      return -1
    }
    var f,s = 0
    while (f < hl ){
      if (hl -f < nl){
        return -1
      }
      if (haystack.charAt(f) != needle(0)){
        f +=1
      }else{
        breakable{
          for (i <- 0 until (nl)) {
            s = f + i
            if (haystack(s) != needle(i)) {
              f += 1
              break
            }
            if (i == nl -1){
              return f
            }
          }
        }

      }
    }
    -1

  }


  /**
   *
   *
   * 要减少搜索词次数，需要看有没有可以重复匹配的模式串
   * 假设字符串s，已经匹配到下标为j的字符，有两种情况
   *    1. j+1 与待匹配的字符相等，继续向后匹配
   *    2. j+1与待匹配的字符不相等，已经不能再向后匹配，需要向前看，如果存在k使得 s[j-k,j](后缀) 与 s[0,k]（前缀） 的字符串完全相同，此时我们便可以直接从k+1与待匹配字符比较
   *    3. 如果不匹配，继续向前查找相同的模式，直到 k=0 且 s[0] 与待匹配字符也不相等
   * 所以此时我们需要知道在一个模式串P中以y为终点，最长的相同的前缀与后缀
   *
   *
   * 假设数组next 记录模式串P中以y为终点的最长相同前缀的下标m,如果没有则记为-1
   * 当我们求next[y+1]时 需要检查 m = next[y];   P[y+1] == P[m+1] ?  {m = m+1;next[y+1]=m;求next[y+2]} : 继续向前探查m = next[m] 直到 m=-1&&P[m+1] != P[y+1] 则 next[y+1]=-1
   * 初始状态next[0] = -1
   *
   * [a, b, c, s, d, f, a,b,c]
   * [-1,-1,-1,-1,-1,-1,0,1,2]
   *
   * [a, a, c, s, d, f,a, b, c]
   * [-1,0,-1,-1,-1,-1,0,-1,-1]
   *            ---
   *            | -1 {i=0}
   * next[i] =  | max(P[0,……,k] == P[i-k,……,i])  {i > 1, 1< k < i}
   *           |  0
   *           --
   *
   * [a,a,c,s,d,f,a,b,c]
   * [-1,0,0,0,0,0,0,1,2]
   *
   * @param haystack
   * @param needle
   * @return
   */
  def strStrKMP(haystack: String, needle: String): Int = {
    search(haystack,needle,getNext(needle))
  }


  /**
   * 获取KMP的next数组
   *  问题转化
   *  设字符串 S，索引下标为j
   *  求 以S[j]为终点的后缀与以S[0] 为起点的前缀的最长相同子串
   *  S[0,j]中，后缀指 除 S[0] 外，始终包含S[j]的子串，前缀指 除 S[j] 外 始终包含S[0]的子串
   *
   *
   *  状态就是
   *  假设f(j) 为相同前缀的下标值
   *  f(j) = max{k|0 < k < j| S[0]S[1]..S[k-1] == S[j-k]S[j-k+1]……S[j-1] }
   *  初始状态
   *  f(0) = -1
   *
   *  状态转移方程
   *
   *  要求与以j+1为终点的后缀相同的前缀，需要看以j为终点的后缀有没有相同的前缀，如果有则找到该前缀 i，将 S[i+1]与S[j+1] 进行比较，如果相同相同的长度+1，如果不同，则继续向前查找，直至找到有相同前缀或第一个字符也与S[j+1] 不同，此时f(j+1) = 0
   *
   *
   *  f(j+1) = if(S[f(j)] ==  S[j+1]) then f(j)+1 else f(f[j]-1)
   *
   *
   *
   *  要减少搜索词次数，需要看有没有可以重复匹配的模式串
   *  假设字符串s，已经匹配到下标为j的字符，有两种情况
   *    1.  j+1 与待匹配的字符相等，继续向后匹配
   *    2. j+1与待匹配的字符不相等，已经不能再向后匹配，需要向前看，如果存在k使得 s[j-k,j](后缀) 与 s[0,k]（前缀） 的字符串完全相同，此时我们便可以直接从k+1与待匹配字符比较
   *    3. 如果不匹配，继续向前查找相同的模式，直到 k=0 且 s[0] 与待匹配字符也不相等
   *
   *
   *
   * @param needle
   * @return
   */
  def getNext(needle:String): Array[Int] = {
    val l = needle.length
    val next = Array.ofDim[Int](l)
    next(0) = -1
    var i = 1;
    // issip
    //-10001
    // abcabcd
    //-100012
    var k = next(i-1)
    while (i < l) {
      if(k == -1){
        if(needle.charAt(i) == needle.charAt(k+1)){
          k+=1
          next(i) = k
          i+=1
        }else{
          next(i)=k
          i+=1
        }
      }else{
        if(needle.charAt(i) == needle.charAt(k+1)){
          k+=1
          next(i) =k
          i+=1
        }else{
          k = next(k)
        }
      }

      /*if (k == -1 || needle.charAt(i) == needle.charAt(k)){
        k+=1
        next(i) = k
        i+=1
      }else{
        k = next(k)
      }*/
    }

    next
  }


  /**
   * 通过next数组获取匹配
   * absdabcabcsdf
   * [ a,b,c,a,b,c]
   * [-1,0,0,0,1,2]
   *
   *
   *
   *
   * @param needle
   * @return
   */
  def search(haystack: String, needle: String,next:Array[Int]): Int = {
     val hl = haystack.length
     val nl = needle.length
     var i,j = 0
     j = next(0)
     while (i < hl && j < nl-1){

       if (j == -1){
         if (haystack.charAt(i) == needle.charAt(j+1)){
           i += 1
           j += 1
         }else{
           i+=1
         }
       }else{
         if (haystack.charAt(i) == needle.charAt(j + 1)) {
           i += 1
           j += 1
         }else{
           j = next(j)
         }
       }



     /*  if (j == -1 && haystack.charAt(i) == needle.charAt(j)) {
         i += 1
         j += 1
       }else{
         j = next(j);
       }*/
     }
    if (j == nl-1){
      return i-nl
    }
    -1
  }







}
