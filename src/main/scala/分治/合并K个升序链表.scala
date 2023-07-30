package 分治

import 分治.合并K个升序链表.ListNode

import scala.collection.mutable

object 合并K个升序链表 {


  def main(args: Array[String]): Unit = {

  }


  /**
   * 两种思路
   * 1. 归并排序 先合并两个有序链表，与剩下的链表又会构成一组有序链表，递归合并
   * 2. 使用堆
   *  1. 将每个链表的头取出来，初始化堆
   *  2. 将堆中最小的元素取出，并将该元素的next取出放入堆中，如果next 不存在则不放
   *  4. 循环操作第二步
   * @param lists
   * @return
   */
  def mergeKLists(lists: Array[ListNode]): ListNode = {

    object vCompare extends Ordering[ListNode]{
      override def compare(x: ListNode, y: ListNode): Int ={
        y.x -x.x
      }
    }

    val heap = new mutable.PriorityQueue[ListNode]()(vCompare)
    for (node <- lists){
      heap.enqueue(node)
    }
    val head = ListNode()
    var pre = head
    while (!heap.isEmpty){
      val cur = heap.dequeue();
      if(cur.next != null){
        heap.enqueue(cur.next)
        cur.next = null
      }
      pre.next = cur
      pre = cur
    }
    head.next
  }




  class ListNode(_x: Int = 0, _next: ListNode = null) {

    var next: ListNode = _next

    var x: Int = _x
  }

}
