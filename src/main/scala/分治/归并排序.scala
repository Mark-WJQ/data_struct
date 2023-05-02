package 分治

object 归并排序 {

  def main(args: Array[String]): Unit = {
    var array:Array[Int] = Array(1,5,3,2,6);
    var tmp:Array[Int] = Array.ofDim[Int](5);
    mergeSort(0,4,array,tmp)
    for (a <- array){
      println(a)
    }
  }


  def mergeSort(s:Int,e:Int,array: Array[Int],tmp:Array[Int]):Unit = {
      if(s >= e){
        return
      }
      var m = (e + s) / 2;
      mergeSort(s, m, array, tmp)
      mergeSort(m + 1, e, array, tmp)
      merge(array, s, m, e, tmp)

  }


  def merge(src: Array[Int], s: Int, m: Int, e: Int, pos: Array[Int]) = {
    var i = s
    var j = m+1
    var p = s
    while (i <= m && j <= e){
      var tmp = src(i)
      if(src(i) <= src(j)){
        tmp = src(i)
        i+=1
      }else{
        tmp = src(j)
        j+=1
      }
      pos(p) = tmp;
      p+=1
    }
    while (i <= m){
      pos(p) = src(i)
      i+=1
      p+=1
    }
    while (j <= e){
      pos(p) = src(j)
      j+=1
      p+=1
    }
    for (k <- s to e){
      src(k) = pos(k)
    }
  }


}
