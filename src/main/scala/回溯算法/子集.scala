package 回溯算法

/**
 * 力扣78
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
object 子集 {


  def main(args: Array[String]): Unit = {
    subsets(Array(1,2,3))
  }


  /**
   * 问题可以提取成在遍历到第i个元素的时候，是否要包含在子集中
   * 有两种方法 1. 不包含 2. 包含
   * 接着再判断 i+1 个元素如何放
   *
   * 当i >= length 时就表示这一轮已经遍历结束了，回退回去再看其他情况
   *
   *
   * @param nums
   * @return
   */

  def subsets(nums: Array[Int]): List[List[Int]] = {
    var result = List[List[Int]]()
    var path = List[Int]()
    def subsets(nums: Array[Int],idx:Int): Unit = {
      if (idx >= nums.length){
        result = result.appended(path)
        return
      }
      subsets(nums,idx+1)
      path = path.appended(nums(idx))
      subsets(nums,idx+1)
      path = path.dropRight(1)
    }
    subsets(nums,0)
    result
  }




}
