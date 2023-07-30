package 动态规划

object 旋转函数 {


  def main(args: Array[String]): Unit = {
    println(maxRotateFunction(Array(4,3,2,6)))
    println(maxRotateFunction(Array(100)))
  }

  def maxRotateFunction(nums: Array[Int]): Int = {

    val l = nums.length
    if(l  <= 1){
      return 0
    }
    var max = Int.MinValue
    for (i <- l-1 to (0) by -1){
      var cur: Int = 0;
      for (j <- 0 until(l)){
        val k = (i+j)%l
        cur += nums(k)*j
      }
      max = math.max(cur,max)
    }
    max
  }

}
