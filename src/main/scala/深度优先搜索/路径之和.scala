package 深度优先搜索

import scala.collection.mutable.ListBuffer

object 路径之和 {

  def main(args: Array[String]): Unit = {

  }



  val path = ListBuffer[Int]()

  var pathList = List[List[Int]]()


 /* def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
    if (root == null) {
      return pathList
    }
    if (targetSum == root.value && root.right == null && root.left == null) {
      path.addOne(root.value)
      pathList = pathList.::(path.map(a => a).toList)
      path.remove(path.size - 1)
      return pathList
    }
    val l = targetSum - root.value
    path.addOne(root.value)
    pathSum(root.left, l)
    pathSum(root.right, l)
    path.remove(path.size - 1)
    pathList
  }*/

  def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
    val pathList = ListBuffer[List[Int]]()
    pathSum(root,targetSum, pathList)
    pathList.toList
  }


  def pathSum(root: TreeNode, targetSum: Int,pathList:ListBuffer[List[Int]]): Unit = {
    if (root == null) {
      return 
    }
    if (targetSum == root.value && root.right == null && root.left == null) {
      path.addOne(root.value)
      pathList.addOne(path.map(a => a).toList)
      path.remove(path.size - 1)
      return
    }
    val l = targetSum - root.value
    path.addOne(root.value)
    pathSum(root.left, l)
    pathSum(root.right, l)
    path.remove(path.size - 1)
  }
  


  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value

    var left: TreeNode = _left

    var right: TreeNode = _right

  }

}
