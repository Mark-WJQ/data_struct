package 枚举

import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

/** * 解题思路 有一些问题是有局部状态的，这些局部状态只有有限的n种，一旦局部状态确定以后，其他状态也会跟着确定
  * 在这个问题中第一行就是就不状态，一旦第一行确定以后，其他行都是确定的，因为下一行需要把上一行的灯熄灭掉 一个按钮重复多次效果会抵消，所以按一次即可
 *
 *
 *
0 1 1 0 1 0
1 0 0 1 1 1
0 0 1 0 0 1
1 0 0 1 0 1
0 1 1 1 0 0
0 0 1 0 1 0
1 0 1 0 1 1
0 0 1 0 1 1
1 0 1 1 0 0
0 1 0 1 0 0

PUZZLE#1
101001
110101
001011
100100
010000
PUZZLE#2
100111
110000
000100
110101
101101
  */
object 熄灯问题 {
  def main(args: Array[String]): Unit = {

    val left = Array.tabulate(5)(_ => 1)
    val right = Array.tabulate(5)(_ => 1)


    val lightsArray: Array[Array[Char]] = readLight();

    for (num <- 0 to lightsArray.length) {
      val result = Array.ofDim[Char](5);
      val lights = lightsArray(num )
      val cplights = Array.ofDim[Char](5);
      breakable {
        for (a: Int <- 1 to 63) {
          lights.copyToArray(cplights)
          // 开关
          var switchs = a.toChar;
          // 每一行
          for (i <- 0 to 4) {
            if (i > 0) {
              cplights(i - 1) = (cplights(i - 1) ^ switchs).toChar
            }

            var l = cplights(i)
            for (j <- 0 to 5) {
              val b = getBit(switchs, j)
              if (b > 0) {
                l = flipBit(l, j)
                if (j > 0) {
                  l = flipBit(l, j - 1)
                }
                if (j < 5) {
                  l = flipBit(l, j + 1)
                }
              }
            }
            cplights(i) = l
            if (i < 4) {
              cplights(i + 1) = (cplights(i + 1) ^ switchs).toChar
            }
            result(i) = switchs;
            switchs = cplights(i);
          }
          if (cplights(4) == 0.toChar) {
            outputResult(num, result)
            break
          }
        }

      }
    }

    /*buttons.grouped(5).foreach(b =>{
     val cplights = Array.ofDim[Int](5,5)
     lights.copyToArray(cplights)
     for (x <- 0 to 4){
       for (y <- 0 to 4){
        val l = lights(x)(y)
         var r = 1
         if(x == 0){
           if (y == 0){
              r = b(x)(y) &  b(x)(y+1) & b(x+1)(y)
           }
           else if( y == 4){
              r = b(x)(y) & b(x)(y-1) &  b(x+1)(y)
           }else{
              r = b(x)(y)  & b(x)(y+1) & b(x-1)(y) & b(x+1)(y)
           }
         }else if (x == 4) {
           if (y == 0) {
              r = b(x)(y) & b(x)(y + 1) & b(x - 1)(y)
           }
           else if (y == 4) {
              r = b(x)(y) & b(x)(y - 1) & b(x - 1)(y)
           } else {
              r = b(x)(y) & b(x)(y + 1) & b(x - 1)(y) & b(x - 1)(y)
           }
         }else {
           if (y == 0) {
              r = b(x)(y) & b(x)(y + 1) & b(x - 1)(y)& b(x + 1)(y)
           }
           else if (y == 4) {
              r = b(x)(y) & b(x)(y - 1) & b(x - 1)(y)& b(x - 1)(y)
           } else {
              r = b(x)(y) & b(x)(y - 1) & b(x)(y + 1) & b(x - 1)(y) & b(x + 1)(y)
           }
         }
         cplights(x)(y) = l^r
      }
     }
     println("PUXXLE#"+num);
     println(cplights)
     num +=1
   })*/

  }



  def readLight():Array[Array[Char]]={
    val count = StdIn.readInt();
    val lightsArray: Array[Array[Char]] = Array.ofDim(count, 5);

    for (i <- 1 to count) {
      // 初始化
      val lights = Array.ofDim[Char](5)
      for (c <- 0 to 4) {
        val rl = StdIn.readLine()
        val bitv = rl
          .split(" ")
          .map(r => r.toInt)
        for (i <- 5 to 0 by -1) {
          val b = bitv(i)
          lights(c) = setBit(lights(c), 5 - i, b)
        }
      }
      lightsArray(i - 1) = lights
    }
    lightsArray
  }



  def flipBit(a: Char, pos: Int): Char = {
    (a ^ (1 << pos)).toChar
  }

  def setBit(a: Char, pos: Int, v: Int): Char = {
    if (v > 0) {
      (a | (1 << pos)).toChar
    } else {
      (a & ~(1 << pos)).toChar
    }
  }
  // 10010

  def getBit(a: Char, pos: Int): Int = {
    (a >> pos) & 1
  }

  def outputResult(n: Int, result: Array[Char]) = {

    println("PUZZLE#" + n)
    for (v <- result) {
      for (i <- 5 to 0 by -1) {
        print(getBit(v, i))
      }
      println()
    }
  }
}
