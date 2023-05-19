package 深度优先搜索

import 深度优先搜索.课程表.{Pre, canFinish}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{breakable,break}

object 课程表2 {

  def main(args: Array[String]): Unit = {
    //println(findOrder(8,Array(Array(1,0),Array(2,0),Array(3,1),Array(0,4),Array(0,5),Array(4,6))))
   // println(findOrder(3,Array(Array(0,1),Array(0,2),Array(1,2))))
    println(findOrder(3,Array(Array(0,1),Array(1,0))))


  }


  case class Pre(p:ListBuffer[Int],var init:Int){}


  /**
   *
   * 在交叉节点的两边分别广度遍历，遍历完成后再合并，知道完全遍历
   *
   *
   * @param numCourses
   * @param prerequisites
   * @return
   */
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val tailChain = Array.ofDim[Pre](numCourses)
    val tailSize = Array.ofDim[Int](numCourses)
    val chain = Array.ofDim[Pre](numCourses)

    for (arr <- prerequisites) {
      var tail = tailChain(arr(0))
      if (tail == null) {
        val buff = ListBuffer(arr(1))
        tail = Pre(buff, 0)
        tailChain(arr(0)) = tail
      } else {
        tail.p.addOne(arr(1))
      }
      tailSize(arr(0))+=1

      var pre = chain(arr(1))
      if (pre == null) {
        val buff = ListBuffer(arr(0))
        pre = Pre(buff, 0)
        chain(arr(1)) = pre
      } else {
        pre.p.addOne(arr(0))
      }
    }
    val visited = Array.ofDim[Int](numCourses)
    val q = mutable.Queue[Int]()
    for (i <- 0 until (numCourses)) {
      if (tailSize(i) == 0) {
        q.enqueue(i)
        visited(i) = 1
      }
    }
    val result = Array.ofDim[Int](numCourses)
    var index = 0
    while (q.nonEmpty){
      val e = q.dequeue()
      result(index) = e
      index +=1
      val pre = chain(e)
      if (pre != null){
        pre.p.foreach(p =>{
          tailSize(p)-=1
          if (tailSize(p) == 0){
            q.enqueue(p)
          }
        })
      }
    }
    if(index == numCourses){
      return result
    }
    Array()
  }








}
