package 链表

/**
 * lettcode 160
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。


 */
object 链表相交 {


  def main(args: Array[String]): Unit = {

  }


  /**
   * 假设
   * 链表 A ，长度为 m，其中 B 相交的长度为 c，自身的长度为 a, m = a + c
   * 链表 B ，长度为 n，其中 A 相交的长度为 c，自身的长度为 b, n = b + c
   *
   * a + c + b  = b + c + a
   *
   * 从上面公式看分别遍历A，B两个链表，并且接着遍历非共有节点，最终遍历的节点个数是一样的，即他们最终到达相同的节点，如果A跟B没有相交，则终点为null，如果有相交，则是第一个相交的点
   *
   * 设两个指针 ha,hb,ha指向A的头结点，hb指向B的头结点，ha，hb 同时向右移动，如果ha==hb 结束遍历找到相交点，当ha遍历到终点且hb不为null，则将ha指向B的头结点，同理hb
   *
   *
   * @param headA
   * @param headB
   * @return
   */
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {

    var ha = headA // 3
    var hb = headB // 2,3

    while (ha != hb){
      if (ha == null){
        ha = headB
      }else{
        ha = ha.next
      }
      if(hb == null){
        hb = headA
      }else{
        hb = hb.next
      }
    }
    ha

  }


  class ListNode(var _x: Int = 0) {

    var next: ListNode = null

    var x: Int = _x

  }

}
