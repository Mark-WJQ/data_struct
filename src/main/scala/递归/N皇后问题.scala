package 递归

import scala.io.StdIn
import scala.math.abs
import scala.util.control.Breaks.{break, breakable}


/**
 * 输入一个正整数N，则程序输出N皇后问题的所有摆法。输出结果里每一行都代表一种摆法，行里的第i个数字如果是n，就代表第i行的皇后应该放在第n列，皇后的行列编号都是从1开始算
 *
 * 假设前n 行已经摆放好，摆放 n+1 行皇后
 *
 * 两个比较,假设正在摆放第k个皇后
 * 1. 第j行的皇后是否也摆放在第i列  q[j] == i
 * 2. 斜线上是否已经摆放过皇后  第j行的皇后摆放的位置q[j]-i == abs[j-k]，相当于一个直角三角形，宽高一样
 *
 *
 */
object N皇后问题 {


  val q = Array.ofDim[Int](100);
  var N = 0;

  def main(args: Array[String]): Unit = {


    val n = StdIn.readInt();
   // val  arr = Array.ofDim[Int](n,n);
    //nQuene(n,arr)
    N = n;
   nQuene(1);


  }


  def nQuene(k:Int): Unit = {
    if(k == N+1){
      for (i <- 1 to N){
        print(q(i))
        print(" ")
      }
      println()
    }
    // 遍历列

      for (i <- 1 to N) {
        // 检查在第i列放皇后是否与第j行的皇后有冲突
        var x = 0;
        breakable {
          for (j <- 1 until k) {
            if (q(j) == i || abs(q(j) - i) == (k - j)) {
             // println( k +" " + i + " " + j)
              break
            }
            x = j
          }
        }
        if (x == k - 1) {
          q(k) = i
          nQuene(k + 1)
        }


    }
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
