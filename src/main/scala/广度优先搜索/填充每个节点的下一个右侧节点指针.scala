package 广度优先搜索

import scala.collection.mutable


object 填充每个节点的下一个右侧节点指针 {

  def main(args: Array[String]): Unit = {
    val root = Node(1)
    val left = Node(2)
    val right = Node(3)
    root.left = left
    root.right = right

    connect(root);
  }


  def connect(root: Node): Node = {
    if (root == null){
      return null
    }
    val queue = new mutable.Queue[Node]
    queue += root
    var pre:Node = null;

    var level = 0;
    var count = math.pow(2,level)
    while (!queue.isEmpty){
      if (count == 0){
        level+=1
        count = math.pow(2,level)
        pre = null
      }
      while (count > 0){
        val node = queue.dequeue()
        if (pre != null) {
          pre.next = node;
        }
        pre = node
        if(node.left != null) {
          queue.enqueue(node.left)
        }
          if (node.right != null){
            queue.enqueue(node.right)
          }
        count-=1
      }
    }
    root

  }


  class Node(var _value: Int) {

    var value: Int = _value

    var left: Node = null

    var right: Node = null

    var next: Node = null
  }

}
