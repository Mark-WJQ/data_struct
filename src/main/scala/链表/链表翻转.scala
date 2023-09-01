package 链表

object 链表翻转 {

  def main(args: Array[String]): Unit = {

  }


  /**
   * 双指针
   * 一个指针指向已翻转的头结点H1 另一个指针指向未翻转的头结点H2
   * 接下来的操作需要将 next = H2.next;H2.next=H1 ;H1=H2;H2=next,while H2!=null
   *
   *
   *
   *
   *
   * 递归解法
   * 先把剩下的翻转，然后
   * @param node
   * @return
   */
  def revert(node: Node): Node = {
    if(node.next == null){
      return node;
    }
    val cur =revert(node.next)
    cur.next = node
    node.next = null
    cur
  }
}

class Node(var next:Node){
}
