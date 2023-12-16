package 数组

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 */
class 全排列 {



  val result: ListBuffer[List[Int]] = ListBuffer()




  /**
   * 当nums 只有一个元素 a 时  全排列只有一种情况 [a]
   * 当nums 有两个元素ab时 有两种情况 ab,ba
   * 当nums有三个元素 abc时，有 abc、bac、cab、cba、acb、bca
   * 当nums有n个元素时，在n-1个元素的全排列上可以推断出来，分别是加前缀、后缀、中间
   *
   * 这种算法复杂度太高，列表的调整都需要移动元素
   *
   *
   * 回溯算法
   * 排列问题
   *  排列第i个位置的时候，有n-i个元素可选，最终排到第n个位置的时候说明已经排列完
   *  使用一个与nums大小相同的数组 visited 记录已经使用过的元素，在排列后再回溯其他元素
   *
   *
   *
   *
   *
   *
   *
   * @param nums
   * @return
   */


  def permute(nums: Array[Int]): List[List[Int]] = {

    var visited:Array[Boolean] = Array.ofDim(nums.length);
    var tmp = Array.ofDim[Int](nums.length)

    val result = List()

    result
  }




 def arrange(visited:Array[Boolean],j:Int, tmp:Array[Int],nums: Array[Int]): Unit = {

   val l = visited.length
   if (j == l){
     // todo 打印结果,使用一个全局变量将结果收集起来
     println(tmp.mkString)
     result+=(tmp.toList)
   }

   for (i <- 0 until(l)){
     if (!visited(i)){
       visited(i) = true
       tmp(j) = nums(i)
       arrange(visited,j+1,tmp,nums)
       visited(i) = false
     }
   }
 }

}

object 全排列{


  def main(args: Array[String]): Unit = {
    var nums: Array[Int] = Array(1, 2, 3, 4)
    var visited: Array[Boolean] = Array.ofDim(nums.length);
    var tmp = Array.ofDim[Int](nums.length)

    var r = 全排列()


    r.arrange(visited, 0, tmp, nums)
    println(r.result.mkString)




  }


}


