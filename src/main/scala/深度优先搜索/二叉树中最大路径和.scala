package 深度优先搜索

/**
 * leetcode 124
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
object 二叉树中最大路径和 {

  def main(args: Array[String]): Unit = {

  }


  var max = Int.MinValue

  /**
   *
   *  从当前节点出发 x，求左子树中以根为起点的最大路径和 sl =max(sl,0)、右子树中以根为起点的最大路径和 sr = max(rl,0)
   *  加上当前节点后可以求出包含当前节点的树的路径和 sum = max(sum,x+sl+rl)
   *  当到达叶子节点时，最大路径和就是当前节点的值，如果节点为空则路径和为 0
   *
   *  同时在求父级树的时候，由于路径只能选向左还是向右，所以只能挑左右路径和最大的一条
   *
   *
   * @param root
   * @return
   */

  def maxPathSum(root: TreeNode): Int = {
    if(root == null){
      return 0
    }
    val sl = math.max(maxPathSum(root.left),0)
    val rl = math.max(maxPathSum(root.right),0)
    val cur = root.value + sl + rl
    max = math.max(cur,max)
    root.value + math.max(sl,rl)
  }




  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

}
