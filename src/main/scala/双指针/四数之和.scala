package 双指针

import scala.util.control.Breaks.{break, breakable}

object 四数之和 {

  def main(args: Array[String]): Unit = {
    println(Int.MaxValue)
    println(fourSum(Array(1000000000,1000000000,1000000000,1000000000),-294967296))
  }


  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    val sortNums = nums.sorted
    val l = nums.length
    var result = List[List[Int]]()
    for (i <- 0 until(l-2)){
      breakable {
        if (i > 0 && sortNums(i) == sortNums(i - 1)) {
          break
        }
        val d = target - sortNums(i)
        val tr = threeSum(sortNums, d, i + 1)
        if (tr.size > 0) {
          tr.foreach(
            r =>
              val r1 = r.::(sortNums(i))
              if(r1.map(v => v.toLong).sum == target.toLong) {
                result = r1 :: result
              }
          )
        }
      }
    }
    result
  }


  def threeSum(nums: Array[Int],d:Int,s:Int): List[List[Int]] = {
    val sortNums = nums
    val l = nums.length
    var result = List[List[Int]]()

    for (i <- s until (l - 1)) {
      breakable {
        if (i > s && sortNums(i) == sortNums(i - 1)) {
          break
        }
        var t = sortNums(i)
        var left = i + 1
        var right = l - 1
        var target = d - t;
        while (left < right) {
          breakable {
            val r = sortNums(left) + sortNums(right)
            if (left + 1 < right - 1 && sortNums(left) == sortNums(left + 1) && sortNums(right - 1) == sortNums(right)) {
              if (r == target) {
                left += 1
                right -= 1
                break
              }
            }
            if (target == r) {
              result = (List(t, sortNums(left), sortNums(right))) :: result
              left += 1
              right -= 1
            } else if (target > r) {
              left += 1
            } else {
              right -= 1
            }
          }
        }
      }
    }
    result
  }

}
