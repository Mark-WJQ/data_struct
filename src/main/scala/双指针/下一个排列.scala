package 双指针

import scala.util.control.Breaks.{break, breakable}

object 下一个排列 {

  def main(args: Array[String]): Unit = {
    val array = Array(2,2,0,4,3,1)
    nextPermutation(array)
    println(array.toList)
  }


  def nextPermutation(nums: Array[Int]): Unit = {
    val l = nums.length

    for (i <- l - 2 to 0 by -1) {
      if (nums(i) < nums(i + 1)) {
        /*System.arraycopy(nums, i, nums, i + 1, l - i-1)*/
        breakable{
        for(j <- l-1 until(i) by -1){

            if (nums(j) > nums(i)) {
              val tmp = nums(i)
              nums(i) = nums(j)
              nums(j) = tmp
              reverse(nums,i+1)
              break
            }
          }
        }
        return
      }
    }
    reverse(nums,0)
  }


  def reverse(nums: Array[Int],pos:Int): Unit = {
    var k = pos
    var l = nums.length - 1

    while (k < l) {
      var tmp = nums(k)
      nums(k) = nums(l)
      nums(l) = tmp
      k += 1
      l -= 1
    }
  }

}
