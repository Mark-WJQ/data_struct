package 分治

object 输出前m大的数 {

  /**
   * 给定一个数组包含n个元素，统计前m大的数，并且把这m个数从大到小输出
   * 输入：
   * 第一行包含一个整数n，表示数组的大小，n< 100000
   * 第二行包含n个整数，表示数组的元素，整数之间以一个空格隔开，每个整数的绝对值不超过10000000000
   * 第三行包含一个整数m，m<n
   * 输出：
   * 从大到小输出前m大的数，每个数一行
   *
   * 思路：
   * 1. 可以先排序再输出，时间复杂度O(nlogn)
   * 2. 用分治处理，时间复杂度O(n+mlogm)
   *   1. 把前m大的数都弄到数组的右边，再对最右边m个数组排序，再输出
   *   2. 关键 O(n) 时间内实现把前m大的数弄到数组最右边
   *
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {

  }

  def getMaxM(array: Array[Int],m:Int,n:Int)={
    arrangeRight(array,m,0,n-1)
    sort(array,m)
    out(array,m);
  }

  def arrangeRight(array: Array[Int],m:Int,s:Int,e:Int): Unit = {
    if ( m == 0 || s == e){
      return 
    }
    var base = array(s)
    var i = s
    var j = e
    while (i < j){
      while (i < j && base < array(j)){
        j-=1
      }
      swap(array,j,i)
      while (i < j && base >= array(i)) {
        i += 1
      }
      swap(array, i, j)
    }
    if (e - i > m){
      arrangeRight(array, m, i+1, e)
    }else{
      arrangeRight(array,m-e-i,s,i-1)
    }
  }

  def swap(array: Array[Int], i: Int, j: Int): Unit = {
    var tmp = array(i)
    array(i) = array(j)
    array(j) = tmp
  }
  
  def sort(array: Array[Int],m:Int): Unit = {
    var l = array.length
    快排.quickSort(array,l-m,l-1)
  }
  
  def out(array: Array[Int],m:Int): Unit = {
    val l = array.length
    for (i <- 1 to m){
      println(array(l-i))
    }
  }





}
