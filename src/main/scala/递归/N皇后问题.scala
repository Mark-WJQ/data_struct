package 递归

import scala.io.StdIn

object N皇后问题 {


  def main(args: Array[String]): Unit = {


    val n = StdIn.readInt();
    val  arr = Array.ofDim[Int](n,n);
    nQuene(n,arr)
  }


  def nQuene(i:Int,arr:Array[Array[Int]]):Boolean={

    if(i == 0){
      outPutArr(arr)
      println()
      return true
    }


    // 遍历列
    for (j <- 0 to arr.length-1) {
      //如果i，j 满足皇后摆放规则，校验下一行
      if (check(i-1, j, arr)) {
        val l = arr.length
        arr(i-1) = Array.ofDim(l)
        arr(i-1)(j) = 1;
        nQuene( i - 1, arr)

      }
    }
    false
  }


  def outPutArr(arr: Array[Array[Int]]): Unit = {
    (0 to arr.length-1)
      .foreach(i => for (j <- 0 to arr.length-1) {
        if (arr(i)(j) != 0) {
          print(j+1)
          print(" ")
        }
      })
  }

  def check(i:Int,j:Int,arr:Array[Array[Int]]): Boolean = {
    if (i == arr.length -1){
      return true;
    }
    (i+1 to arr.length-1).foreach(k =>{
      if(arr(k)(j) == 1){
        return false;
      }
      if(j + (k-i) < arr.length){
        if (arr(k)(j + (k-i)) == 1) {
          return false;
        }
      }

      if (j - (k - i) >= 0) {
        if (arr(k)(j - (k - i)) == 1) {
          return false;
        }
      }
    })
   true
  }




}
