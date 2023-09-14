package 链表

/**
 * leetcode 61
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。


 */
object 链表旋转 {


  class ListNode(_x: Int = 0, _next: ListNode = null) {

    var next: ListNode = _next

    var x: Int = _x

  }


  /**
   * 假设链表元素有m个
   * 起点不一样的快慢指针，先找最右边的k个元素，将这k个元素与前m-k个元素断开，且将tail 指向 head，第m-k个元素重新变为头结点
   *
   * 需要注意的是当k 远大于 m, 此时需要向取余 k=k%m
   *
   *
   *

   *
   *
   * @param head
   * @param k
   * @return
   */
  def rotateRight(head: ListNode, k: Int): ListNode = {


    new ListNode()
  }

}
