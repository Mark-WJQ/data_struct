package 枚举
import scala.util.control.Breaks._
import scala.io.StdIn

/** 解题思路 先假设一枚硬币是轻的，跟结果对比，如果都满足则就是这枚硬币，否则假设一枚硬币是重的看是否满足称重结果
  */

@main def 假币问题: Unit =


  val read = StdIn.readBoolean()

  val result = List(
    ("ABCD", "EFGH", "even"),
    ("ABCI", "EFJK", "up"),
    ("ABIJ", "EFGH", "even")
  )

  breakable {
    
    for (a <- 'A' to 'L') {
      // 轻的
      breakable {
        var cr = true
        for (r <- result) {
            cr = cr && checkLight(a,r)
        }
        if (cr) {
          println(a + "is light")
          break
        }
      }
      // 重的
      breakable {
        var cr = true
        for (r <- result) {
            cr = cr && checkWeight(a,r)
        }
        if (cr) {
          println(a + "is weight")
          break
        }
      }

    }
  }



  def checkLight(a:Char,l:(String,String,String)):Boolean ={


    if ((l._1.contains(a) || l._2.contains(a)) && l._3.equals("even")) {
      return false
    }
    if (!(l._1.contains(a) || l._2.contains(a))&&l._3.equals("even")) {
      return true
    }
    if (l._1.contains(a) && l._3.equals("down")) {
     return  true
    }
    if (l._2.contains(a) && l._3.equals("up")) {
     return true
    }
      
    false

  }


   def checkWeight(a:Char,l:(String,String,String)):Boolean ={


    if ((l._1.contains(a) || l._2.contains(a)) && l._3.equals("even")) {
      return false
    }
    if (!(l._1.contains(a) || l._2.contains(a))&&l._3.equals("even")) {
      return true
    }
    if (l._1.contains(a) && l._3.equals("up")) {
     return  true
    }
    if (l._2.contains(a) && l._3.equals("down")) {
     return true
    }
      
    false

  }

