package 枚举

import scala.collection.immutable.HashMap
import scala.collection.mutable.ListBuffer

object 电话号码的字母组合 {

  def main(args: Array[String]): Unit = {
    println(letterCombinations("23"));
  }


  val map = HashMap[Char,List[String]](
    ('2',List("a","b","c")),
    ('3',List("d","e","f")),
    ('4',List("g","h","i")),
    ('5',List("j","k","l")),
    ('6',List("m","n","o")),
    ('7',List("p","q","r","s")),
    ('8',List("t","u","v")),
    ('9',List("w","x","y","z")))
  def letterCombinations(digits: String): List[String] = {
    if (digits.isEmpty){
      return List()
    }
    letterCombinations(digits,0,digits.length-1)
  }


  def letterCombinations(digits: String,start:Int,end:Int): List[String] = {
    if (end == start){
      val s = digits.charAt(start)
      val sList = map.get(s)
      return sList.get
    }
    val pre = letterCombinations(digits, start+1, end);
    cartesianProduct(map.get(digits.charAt(start)).get,pre)
  }

  def cartesianProduct(a:List[String],b:List[String]):List[String] = {
    val  lb = ListBuffer[String]()
    for (ai <- a){
      for (bi <- b){
        lb.addOne(ai+bi)
      }
    }
    lb.toList

  }




}
