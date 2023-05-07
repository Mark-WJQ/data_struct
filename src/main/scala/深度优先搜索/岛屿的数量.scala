package 深度优先搜索

object 岛屿的数量 {


  def main(args: Array[String]): Unit = {
    val grid = Array[Array[Char]](
      Array('1','1','0','0','0'),
      Array('1','1','0','0','0'),
      Array('0','0','1','0','0'),
      Array('0','0','0','1','1'))

    println(numIslands(grid))
  }


  def numIslands(grid: Array[Array[Char]]): Int = {
    val rl = grid.length
    val cl = grid(0).length
    val result = Array.ofDim[Int](rl,cl)
    var count = 0;
    for (i <- 0 until(rl)){
      for (j <- 0 until(cl)){
        if (grid(i)(j) == '1' && result(i)(j) == 0){
          count+=1
          numIslands(grid,i,j,result)
        }
      }
    }
    count
  }


  def numIslands(grid: Array[Array[Char]],r:Int,c:Int,result: Array[Array[Int]]):Unit = {
    val rl = grid.length
    val cl = grid(0).length
    if (r<0 || c< 0 || r >= rl || c >= cl){
      return
    }
    if(grid(r)(c) == '0'){
      return
    }
    if (result(r)(c) == 1){
      return
    }
    result(r)(c) = 1
    numIslands(grid,r-1,c, result)
    numIslands(grid,r+1,c, result)
    numIslands(grid, r , c+1, result)
    numIslands(grid, r , c-1, result)
  }


}
