package 动态规划

object 二叉树中的最大路径和 {

  def main(args: Array[String]): Unit = {


  }


  /**
   * 中序遍历
   * 在二叉书中从左到右跟从右到左最终求出来的结果是一样的，所以我们只需要关注一个方向的即可
   * 假设一棵树的最大路径和是  f(node)
   *
   * 则有
   * f(root) = min{f(left) + root.val + f(right),f(left),f(right)}
   *
   *
   *
   *
   * @param root
   * @return
   */
  def maxPathSum(root: TreeNode): Int = {
    if (root == null){
      return 0
    }
    val left = maxPathSum(root.left)
    val rootVal = root.value
    val right = maxPathSum(root.right)
    math.max(math.max(left,right),rootVal+left+right)

  }

}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
     var value: Int = _value
     var left: TreeNode = _left
     var right: TreeNode = _right
   }
