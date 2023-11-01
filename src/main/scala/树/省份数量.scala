package 树

import scala.collection.mutable

/** 力扣547 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市
  * c 间接相连。 「省份」是由一组直接或间接链接的城市组成，组内不含有其他没有相连的城市。 现在给定一个 n * n 的矩阵 isConnected
  * 表示城市的链接关系。其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，isConnected[i][j] =
  * 0 表示第 i 个城市和第 j 个城市没有相连。 要求：根据给定的城市关系，返回「省份」的数量
  *
  * 1≤n≤200。 n==isConnected.length。 n==isConnected[i].length。 isConnected[i][j]
  * 为1 或0。 isConnected[i][i]==1。 isConnected[i][j]==isConnected[j][i]。
  */
object 省份数量 {

  /** 解法
    *   1. 并查集 2. 直接或间接关联的城市，可以组成一个集合 3. 遍历矩阵中的每一个点，如果是 1 的话 可以将 i、j
    *      所在的集合直接合并成新的集合 3. 遍历检查有不重复的顶点
    * @param args
    */
  def main(args: Array[String]): Unit = {
    var isConnected =  Array(Array(1,1,0),Array(1,1,0),Array(0,0,1))
    println(findCircleNum(isConnected));

    isConnected =  Array(Array(1,0,0),Array(0,1,0),Array(0,0,1))
    println(findCircleNum(isConnected));

  }


  def findCircleNum(isConnected: Array[Array[Int]]): Int = {
    val n = isConnected.length
    val f = new  UnionFind(n)
    val r = Range(0, n);
    for (i <- r) {
      for (j <- Range(i + 1, n)) {
        if (isConnected(i)(j) == 1) {
          f.union(i,j)
        }
      }
    }
    val set = new mutable.HashSet[Int]();
    for (i <- r){
      set.add(f.find(i))
    }
     set.size

  }


  class  UnionFind(val n:Int){
    var city = Range(0, n).toArray


    def union(i: Int, j: Int): Unit = {
      val iIdx = find(i)
      val jIdx = find(j)
      if (iIdx == jIdx) {
        return
      }
      city(iIdx) = jIdx;

    }

    def find(i: Int): Int = {
      var idx = i
      var root = city(i);
      while (root != idx) {
        city(idx) = city(root)
        idx = root
        root = city(idx)
      }
      root
    }

    def isConnect(i:Int,j:Int): Boolean = {
      find(i) == find(j)
    }
  }





}
