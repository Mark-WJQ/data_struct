package 深度优先搜索

import java.util

/**
 * leetcode 130
 *
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
object 被围绕的区域 {


  def main(args: Array[String]): Unit = {
    var board = Array(Array('X','X','X','X'),Array('X','O','O','X'),Array('X','X','O','X'),Array('X','O','X','X'))
    printBoard("计算前",board)
    solveDfs(board,Array.ofDim[Boolean](4,4),1,1)
    printBoard("结果",board)


    board = Array(Array('X'))
    printBoard("计算前", board)
    //solveDfs(board)
    printBoard("结果", board)

    board = Array(Array('O'))
    printBoard("计算前", board)
   // solveDfs(board)
    printBoard("结果", board)


    board = Array(Array('O','X','X','O','X'),Array('X','O','O','X','O'),Array('X','O','X','O','X'),Array('O','X','O','O','O'),Array('X','X','O','X','O'))
    printBoard("计算前", board)
    solveUf(board)
    printBoard("结果", board)



    board = Array(Array('O','X','X','O','X'),Array('X','O','O','X','O'),Array('X','O','X','O','X'),Array('O','X','O','O','O'),Array('X','X','O','X','O'))
    printBoard("计算前", board)
    solveDfs(board,Array.ofDim[Boolean](5,5),1,1)
    printBoard("结果", board)


  }


  def printBoard(title:String,board: Array[Array[Char]]): Unit = {
    println(title)
    for (i <- board){
      println(i.mkString(","))
    }
  }



  /**
   * 被围绕的含义是在有一片O，上下左右都是X，并且没有到达边界
   *
   * 第一个版本：枚举
   * 遍历每一个元素，检查它的上下左右是否存在X，直到边界，如果都存在则可以将这个位置设为X，如果有一个不存在则跳过
   * 枚举的过程是从上向下，从左向右的过程，所以我们上方跟左方只需要检查最近的一个元素即可，如果是O那么当前元素也一定是O，如果全是X再检查下方跟右面
   *
   * 第二个版本 深度优先遍历
   *  遍历元素，使用一个二维数组记录结果
   *  如果要计算位置board(i,j) 的结果，可以先计算 board(i+1,j) 与 board(i,j+1),然后再结合 board(i-1,j)与board(i,j-1)计算当前位置应该
   * @param board
   */


  /**
   * 从外向里计算，边上的点是确定，由确定推断不确定
   * @param board
   * @param check
   * @param i
   * @param j
   * @return
   */
  def solveDfs(board: Array[Array[Char]],check:Array[Array[Boolean]],i:Int,j:Int):Unit = {
    checkRow(board)
  }





  def checkRow(board: Array[Array[Char]]): Unit = {

    val m = board.length
    val n = board(0).length
    val check = Array.ofDim[Boolean](m,n)
    for (i <- 0 until(n)){
      checkO(0,i,board, check)
      checkO(m-1,i,board, check)
    }

    for (j <- 0 until (m)) {
      checkO(j, 0, board, check)
      checkO(j, n-1, board, check)
    }

    for (i <- 0 until(m)){
      for (j <- 0 until(n)){
        if (board(i)(j) == 'O' && !check(i)(j)){
          board(i)(j) = 'X'
        }
      }
    }

  }


  def checkO(i:Int, j:Int, board: Array[Array[Char]], check:Array[Array[Boolean]]): Unit = {
    if (i < 0 || j < 0){
      return
    }

    val m = board.length
    val n = board(0).length
    if (i >= m || j >= n) {
      return
    }

    if(board(i)(j) == 'X'){
      return
    }
    if (check(i)(j)){
      return
    }
    check(i)(j) = true;
    checkO(i+1,j,board, check)
    checkO(i-1,j,board, check)
    checkO(i,j+1,board, check)
    checkO(i,j-1,board, check)
  }


  /**
   * 使用并查集
   * 使用数据结构来表达节点信息 Node(i,j,parent)
   * 设置一个虚拟节点 vn 来表示所有边界可达的O
   * 将边界上的O与vn 进行union
   * 遍历所有节点，如果当前节点是 'O' 则与它上下左右是O的节点进行 union
   * 遍历检查'O' 是否与 vn 联通，如果联通则不处理，不联通则将 ‘O’ 设置为 ‘X’
   *
   * @param board
   */
  def solveUf(board: Array[Array[Char]]):Unit={
    val m = board.length
    val n = board(0).length
    val un = new UnionNode(m,n)
   val vn = un.defNode
    for (i <- 0 until(m)) {
      for (j <- 0 until (n)) {
        if (board(i)(j) == 'O') {
          val now = new Node(i, j)
          if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            un.union(vn, now)
          } else {
            if (board(i + 1)(j) == 'O') {
              un.union(now, new Node(i + 1, j))
            }
            if (board(i - 1)(j) == 'O') {
              un.union(now, new Node(i - 1, j))
            }
            if (board(i)(j + 1) == 'O') {
              un.union(now, new Node(i, j + 1))
            }
            if (board(i)(j - 1) == 'O') {
              un.union(now, new Node(i, j - 11))
            }
          }

        }
      }

      for (i <- 0 until (m)) {
        for (j <- 0 until (n)) {
          if (board(i)(j) == 'O') {
            if (!un.is_connected(vn, new Node(i, j))) {
              board(i)(j) = 'X'
            }
          }


        }
      }

    }




  }



  class Node(val i:Int,val j:Int){
    override def equals(obj: Any): Boolean = {
      if (obj == null){
        return false;
      }
      val o:Node = obj.asInstanceOf[Node]

      super.equals(obj) || (i == o.i && j == o.j)
    }
  }

  class UnionNode(row:Int,col:Int){
    //val deque = util.Deque[Node]
    var nodeMatrix = Array.ofDim[Node](row,col);
    var defNode = new Node(-1,-1);

    /**
     * 在union中处理，当a与b合并时统一合并到a的parent上
     * @param a
     * @param b
     */
    def union(a:Node,b:Node): Unit = {
     val ap = find(a)
     val bp = find(b)
      if (ap == bp ){
        return
      }
      if (ap == defNode){
        nodeMatrix(bp.i)(bp.j) = ap
      }else if(bp == defNode){
        nodeMatrix(ap.i)(ap.j) = bp
      }else{
        nodeMatrix(ap.i)(ap.j) = bp
      }
    }


    def find(node: Node):Node={
      if (node == defNode){
        return node
      }
      var cur = node
      while (!cur.equals(nodeMatrix(cur.i)(cur.j)) || defNode == nodeMatrix(cur.i)(cur.j) ){
        cur = nodeMatrix(cur.i)(cur.j)
      }
      nodeMatrix(cur.i)(cur.j)
    }

    /**
     * 检测两个节点是否联通
     * @param a
     * @param b
     * @return
     */
    def is_connected(a:Node,b:Node):Boolean={
      find(a) == find(b)
    }



  }



}
