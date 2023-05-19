package 分治

object 求排列的逆序数 {


  /**
   * 考虑 1、2、……、n（n < 1000000） 的排列i1,i2，……，in，如果其中存在j，k，满足j< k 且 ij > ik,那么就称（ij,ik）是这个排列的一个逆序
   *
   *
   *
   * 1. 将数组分成两半，分别求出左半边的逆序数和右半边的逆序数
   * 2. 再算逆序数是由左半边取一个数和右半边取一个数构成
   *
   *
   * 通过改造归并排序，在左右两边排序后归并前，先计算左右两边的的逆序数，
   * 左指针为i，右指针为j
   *
   *
   *
   *
   *
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {
    //val array = Array(3,7,8,10,2,5,11,12)

    val array = Array(1,2,3,1,3)

    //println(count(array,0,2,4))

    println(mergeSort(array,0,4))

  }

  def mergeSort(array: Array[Int], start: Int, end: Int): Int = {

    if (start >= end) {
      return 0
    }
    val mid = (start + end) / 2
    val left = mergeSort(array, start, mid)
    val right = mergeSort(array, mid+1, end)
    val merge = mergeAndCount(array,start,mid,end)
    merge+left+right
  }


  def mergeAndCount(src: Array[Int], s: Int, m: Int, e: Int):Int= {
    var i = s;
    var k = m+1;
    var count = 0

    var tmp = Array.ofDim[Int](e-s+1)
    var idx = 0


    while (i <= m && k <= e){
      while (i <= m && src(i) > src(k)){
        tmp(idx) = src(i)
        idx+=1
        i+=1
        count+=(e-k+1)
      }
      while (k <= e && src(i) <= src(k)){
        tmp(idx) = src(k)
        idx+=1
        k+=1
      }
    }
    while (i <= m){
      tmp(idx) = src(i)
      idx += 1
      i += 1
    }
    while (k <= e) {
      tmp(idx) = src(k)
      idx += 1
      k += 1
    }
    for (j <- s to e){
      src(j) = tmp(j-s)
    }
    count
  }


  def count(src: Array[Int], s: Int, m: Int, e: Int): Int ={
    var i = m
    var j = e
    var c = 0
    while (i >= s && j >m ) {
      while (j > m && src(i) <= src(j)){
        j -=1
      }
      c+=(j-m)
      i-=1
      while(i >= s && src(i) > src(j)){
        c+=(j-m)
        i-=1
      }
    }
    c
  }

}
