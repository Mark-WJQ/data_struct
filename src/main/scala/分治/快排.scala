package 分治

object 快排 {


  def main(args: Array[String]): Unit = {

    var array:Array[Int] = Array(1,5,3,2,6);
    quickSort(array,0,4)
    for (a <- array) {
      println(a)
    }
  }

  def quickSort(array: Array[Int],s:Int,e:Int): Unit = {
    if (s >= e ){
      return
    }
    var base = array(s);
    var i = s;
    var j = e;
    while (i < j){
      while (j >= i && base < array(j)){
        j-=1;
      }

      swap(array,j,i)
      while (i < j && base >= array(i)){
        i += 1
      }
      swap(array,i,j)

    }
    quickSort(array,s,i-1)
    quickSort(array, i+1, e)
  }

  def swap(array: Array[Int],i:Int,j:Int): Unit = {
    var tmp = array(i)
    array(i) = array(j)
    array(j) = tmp


  }
}
