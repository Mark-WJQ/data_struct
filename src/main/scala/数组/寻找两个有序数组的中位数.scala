package 数组

import scala.collection.mutable

/** leetcode 4 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
  * 。算法的时间复杂度应该为 O(log (m+n)) 。
  */
object 寻找两个有序数组的中位数 {

  def main(args: Array[String]): Unit = {

    println(findMedianSortedArrays(Array(1,3),Array(2)))
   println( findMedianSortedArrays(Array(1,2),Array(3,4)))
    println(findMedianSortedArrays(Array(1,2,3,4),Array(5,6)))
    println(findMedianSortedArrays(Array(1,2,3,11,21,23),Array(4,5,6,7,9,10)))
    println(findMedianSortedArrays(Array(),Array(2)))
    println(findMedianSortedArrays(Array(),Array(2,3)))
    println(findMedianSortedArrays(Array(2,2,4,4),Array(2,2,4,4)))
    println(findMedianSortedArrays(Array(1),Array(1)))
    println(findMedianSortedArrays(Array(2,3),Array(1)))
    println(findMedianSortedArrays(Array(2),Array(1,3,4)))









  }

  /** 求中位数，假设要求一个数组 C 的中位数，如果 C 的长度cl 为 奇数 则中位数为 C(cl/2),如果是偶数则为
    * (C(cl/2-1)+C(cl/2))/2 [0,1,2,3,4] 假设两个数组分别为A、B，长度为 al、bl ，要求中位数
    *   1. 此时我们可以先把A、B合并成C，然后再求中位数，时间复杂度为O(al+bl) 2. 目标时间复杂度 O(log (m+n))
    *      基本上使用二分法求解
    *      1. 可以把问题模型转化为求两个数组的第k大的问题 2. 所以此时我们可以假设我们要求两个数据合并后 第 k 个位置的值，如果k =
    *         (al+bl)/2 3. 将两个数组分别取前 k/2 个数据
    *         1. ah= A(k/2-1) 与 bh = B(k/2-1) 2. 假设 ah < bh 那么 A(0 …… k/2-1) 肯定
    *            在前k个元素中 （假设 ah 不在目标数组中，那么将bh前面的全部加入目标数组也不够k个元素，下一个元素就是ah） 3. ah
    *            \== bh 则正好A、B 各占一半 4. 考虑越界问题 A或B的长度 x 小于 k/2 则使用最后一个元素比较 5. k
    *            减去已经确定的长度x 或 k/2, 在剩下的元素中按照上面的步骤取数，直到计算出来
    *
    * @param nums1
    * @param nums2
    * @return
    */
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val l = nums1.length + nums2.length;
    var k = l / 2 + 1
    if(k == 1){
      if (nums1.length > 0){
        return nums1(0)
      }
      return nums2(0)
    }

    var r = Array(k, 0, 0)
    while (r(0) != 0) {
      r = findMedianSortedArrays(nums1, r(1), nums2, r(2), r(0));
    }
    val odd = (l & 1) == 1
    //发生越界
    if (r(1) < 0 || r(1) >= nums1.length){
      if (odd){
        return nums2(r(2))
      }

      // 偶数需要考虑前一个节点是在哪里

      val q = new mutable.PriorityQueue[Int]();
      q.enqueue(nums2(r(2)));
      if (r(1) > 0) {
        q.enqueue(nums1(r(1) - 1))
      }
      if (r(2) > 0) {
        q.enqueue(nums2(r(2) - 1))
      }
      return (q.dequeue() + q.dequeue())*0.5
    }

    if (r(2) < 0 || r(2) >= nums2.length) {
      if (odd) {
        return nums1(r(1))
      }
      val q = new mutable.PriorityQueue[Int]();
      q.enqueue(nums1(r(1)));
      if (r(2) > 0) {
        q.enqueue(nums2(r(2) - 1))
      }
      if (r(1) > 0) {
        q.enqueue(nums1(r(1) - 1))
      }
      return (q.dequeue() + q.dequeue())*0.5
    }
    //未发生越界
    if (odd){
      return math.max(nums1(r(1)),nums2(r(2)))
    }else{
      val q = new mutable.PriorityQueue[Int]();
      q.enqueue(nums1(r(1)));
      q.enqueue(nums2(r(2)));
      if (r(1) > 0){
        q.enqueue(nums1(r(1)-1))
      }
      if (r(2) > 0){
        q.enqueue(nums2(r(2)-1))
      }
     return (q.dequeue() + q.dequeue())*0.5

      //return getMiddle(nums1,r(1),nums2,r(2))

    }





   /* if ((l & 1) == 1) {
      // 奇数
      if (r(1) > r(2)) {
        nums1(r(1))
      } else {
        nums2(r(2))
      }
    } else {
      // 偶数
      if (r(1) > r(2)) {
        nums1(r(1))
      } else {
        nums2(r(2))
      }
    }*/
    // todo 判断应该取哪个值

    0
  }


  def getMiddle(nums1: Array[Int],start1:Int, nums2: Array[Int],start2:Int):Double={
    if(start1 > 0){
      (nums1(start1) + nums1(start1-1))*0.5
    }else{
      (nums1(start1) + nums2(start2-1))*0.5
    }
  }









  /**
   *
   * @param nums1  有序数组1
   * @param start1 数组1开始位置
   * @param nums2  有序数组2
   * @param start2  数组2开始位置
   * @param k 要查找第几个数
   * @return
   */
  def findMedianSortedArrays(
      nums1: Array[Int],
      start1: Int,
      nums2: Array[Int],
      start2: Int,
      k: Int
  ): Array[Int] = {
    val n1 = nums1.length
    val n2 = nums2.length
    //数组越界
    if (start1 >= n1){
      if(n1 == 0){
        return Array(0,-1,start2+k-1)
      }
      return Array(0,start1,start2+k-1)
    }
    if (start2 >= n2){
      if (n2 == 0){
        return Array(0,start1+k-1,-1)
      }
      return Array(0,start1+k-1,start2)
    }
    if (k == 1){
      if (nums1(start1) > nums2(start2)){
        return Array(0,start1-1,start2)
      }else{
        return Array(0,start1,start2-1)
      }
    }
    // 取第m个数
    var m = k / 2;
    var next1 = start1 + math.min(m-1, n1 - start1-1);
    if (start1 >= n1) {
      next1 = n1
    }
    var next2 = start2 + math.min(m-1, n2 - start2-1)
    if (start2 >= n2) {
      next2 = n2
    }
    var t1 = Int.MaxValue
    var t2 = Int.MaxValue
    // todo 判断越界
    if( next1 < n1){
       t1 = nums1(next1)
    }
    if(next2 < n2){
       t2 = nums2(next2)
    }
    if (t1 < t2) {
      Array(k - (next1-start1)-1, next1+1,start2)
    } else if (t2 < t1) {
      Array(k - (next2-start2)-1, start1,next2+1)
    } else {
      //如果正好两个值相等，且下次要找的值为0
      if (k-2-(next2-start2) - (next1-start1) == 0){
       return Array(k-2-(next2-start2) - (next1-start1), next1, next2)
      }
      Array(k-2-(next2-start2) - (next1-start1),  next1+1, next2+1)
    }
  }

}
