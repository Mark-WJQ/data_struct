package 递归

object 汉诺塔 {

  def main(args: Array[String]): Unit = {

    val ta = "A";
    val tb = "B"
    val tc = "C"

    move(ta,tb,tc,4)

  }


  def move(ta:String,tb:String,tc:String,c:Int):Boolean={
    if(c == 1){
      println(s"""$ta ==> $tc""")
      return true
    }
    move(ta,tc,tb,c-1)
    move(ta,tb,tc,1);
    move(tb,ta,tc,c-1)
  }








}
