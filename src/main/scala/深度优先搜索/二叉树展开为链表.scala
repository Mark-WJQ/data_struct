package 深度优先搜索

import scala.collection.mutable

/** lettcode 114 给你二叉树的根结点 root ，请你将它展开为一个单链表： 展开后的单链表应该同样使用 TreeNode ，其中 right
  * 子指针指向链表中下一个结点，而左子指针始终为 null 。 展开后的单链表应该与二叉树 先序遍历 顺序相同。
  */
object 二叉树展开为链表 {

  class TreeNode(
      _value: Int = 0,
      _left: TreeNode = null,
      _right: TreeNode = null
  ) {

    var value: Int = _value

    var left: TreeNode = _left

    var right: TreeNode = _right

  }

  /** 栈，先根遍历, 先将右节点入栈，再将左节点入栈，遍历下一轮
    * @param root
    */
  def flatten(root: TreeNode): Unit = {
    val stack = mutable.Stack[TreeNode]()
    var pre  = TreeNode()
    if(root !=null){
      stack.push(root)
    }
    while (!stack.isEmpty) {
      val node = stack.pop()
      if(node.right != null){
        stack.push(node.right)
      }
      if(node.left != null){
        stack.push(node.left)
      }
      pre.right = node
      pre.left = null
      pre = node
    }
  }

}
