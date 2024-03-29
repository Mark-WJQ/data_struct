package 树

/**
 * 力扣 684
 *
 * 树可以看成是一个连通且 无环 的 无向 图。
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的那个。
 *
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * edges 中无重复元素
 * 给定的图是连通的
 */
object 冗余链接 {


  def main(args: Array[String]): Unit = {

  }


  /**
   *  假设去掉某一个边后，这条边的两点还能联通，说明去掉的边是冗余的
   *
   *  遍历数组 edges，将第i个元素[ai,bi] 去掉，剩余的元素合并成一个并查集 uf，检查ai、bi 在uf是否可以联通
   *  如果可以连通记录[ai,bi], 遍历检查下一个元素
   *
   *
   *  每遍历一个元素就重新构建一次并查集，效果比较差
   *  可以边构建并查集边检查元素，如果检查到元素[ai,bi] 已经连通，则记录并跳过，直到找到最大的元素
   *
   *
   *
   *
   * @param edges
   * @return
   */
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {

    Array(1,2)
  }





}
