package 深度优先搜索

import scala.collection.mutable.ListBuffer


/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
object 课程表 {

  def main(args: Array[String]): Unit = {
    println(canFinish(3,Array(Array(0,1),Array(1,2))))
  }



  case class Pre(p:ListBuffer[Int],var init:Int){}



  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val visited = Array.ofDim[Int](numCourses)

    val chain = Array.ofDim[Pre](numCourses)
    for (arr <- prerequisites){
      var pre = chain(arr(0))
      if (pre == null){
        val buff = ListBuffer(arr(1))
        pre = Pre(buff,0)
        chain(arr(0)) = pre
      }else{
        pre.p.addOne(arr(1))
      }
    }
    for (i <- 0 until(numCourses)){
      if (chain(i) != null){
        if(!canFinish(i,chain,visited)){
          return false
        }
        visited(i) = 1
      }
    }
    true
  }


  def canFinish(s: Int, chain: Array[Pre],visited:Array[Int]): Boolean = {
    if (visited(s) == 1){
      return true
    }
    val pre = chain(s)
    if (pre == null){
      return true
    }
    if (pre.init == 1){
      return false
    }
    pre.init = 1
    for (i <- pre.p){
      val r = canFinish(i,chain,visited)
      if (!r){
        return false
      }
    }
    pre.init = 0
    true
  }

}
