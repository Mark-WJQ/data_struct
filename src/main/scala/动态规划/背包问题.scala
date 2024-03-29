package 动态规划

object 背包问题 {


  /**
   * 有N件物品和一个容积为M的背包。第i件物品的体积
   * w[i]，价值是d[i]。求解将哪些物品装入背包可使价值总
   * 和最大。每种物品只有一件，可以选择放或者不放
   * (N<=3500,M <= 13000)。
   *
   * 解题思路：
   * 1. 子问题 第k件物品放与不放，放入后求体积与价值，
   *  体积是否超过目标体积，找出最大价值
   *
   *  2. 目标体积W，当前物品数 k
   *  f(W,k) = max(f(W,k-1),f(W-w[k],k-1)+d[i])
   *  在放与不放当前物品中选择最大价值
   *  边界条件
   *  当 k<=0 时，没东西了，f(W,k) = 0
   *  当 W<=0 时，包里放不下了，f(W,k) = 0
   *
   * @param args
   */

  def main(args: Array[String]): Unit = {

  }



}
