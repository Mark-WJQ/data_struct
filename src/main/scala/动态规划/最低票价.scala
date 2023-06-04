package 动态规划


/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。

火车票有 三种不同的销售方式 ：

一张 为期一天 的通行证售价为 costs[0] 美元；
一张 为期七天 的通行证售价为 costs[1] 美元；
一张 为期三十天 的通行证售价为 costs[2] 美元。
通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。

返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。
 */
object 最低票价 {
  def main(args: Array[String]): Unit = {
    println(mincostTickets(Array(1,4,6,7,8,20),Array(7,2,15)))
    println(mincostTickets(Array(1),Array(7,2,15)))

    println(mincostTickets(Array(1,2,3,4,5,6,7,8,9,10,30,31),Array(2,7,15)))
    println(mincostTickets(Array(1,4,6,7,8,20),Array(2,7,15)))


  }


  /**
   * 假设旅行第i天花费最小 为f(i)
   *
   * 当旅行 i+1天时
   * f(i+1) = min{f(i-30) + cost(2) ,f(i-7)+cost(1),f(i-1)+cost(0)}
   *
   *
   *
   * 只旅行1天的花费 min({cost(j), 0 =<j < 3})
   *
   *
   *
   * @param days
   * @param costs
   * @return
   */
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    if (days.length == 0){
      return 0
    }
    val day = Array.ofDim[Boolean](365+1);
    val costDays = Array(1,7,30)
    for (i <- days){
      day(i) = true
    }

    val dayCost = Array.ofDim[Int](365+1);
    //dayCost(days(0)-1) = costs(0)
    for(i <- days(0) to(365)) {
        dayCost(i) = dayCost(i - 1)
        if (day(i)) {
          dayCost(i) = dayCost(i)+costs(0)
          for (j <- 0 until (3)) {
           val ds = i - costDays(j)
            if (ds >= 0) {
              dayCost(i) = math.min(dayCost(ds) + costs(j), dayCost(i))
            }else{
              dayCost(i) = math.min(0 + costs(j), dayCost(i))
            }
          }
        }
      if (i == days(days.length-1)){
        return dayCost(i)
      }
    }
    dayCost(365)
  }

}
