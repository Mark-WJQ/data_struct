package 双指针

object 删除有序数组中的重复项 {

  def main(args: Array[String]): Unit = {


  }


  /**
   * 双指针
   *  first，second
   *  1. first = i指向当前节点 num[i]
   *  2. second 从nums[i+1]开始遍历, 下标为 k，直到nums[k] != nums[i]
   *  3. nums[i+1] = nums[k]
   *  4. first = i+1
   *  5. 循环执行以上步骤，直到 k = nums.length
   *
   * @param nums
   * @return
   */
  def removeDuplicates(nums: Array[Int]): Int = {
    val l = nums.length
    if (l < 2){
      return l
    }
    var first,second = 0
    while (second < l){
      if (nums(first) == nums(second)){
        second += 1
      }else{
        first += 1
        nums(first) = nums(second)
      }
    }
    first+1
  }

}
