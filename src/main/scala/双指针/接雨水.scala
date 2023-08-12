package 双指针

import scala.util.control.Breaks.{break, breakable}

object 接雨水{

   def main(args: Array[String]): Unit = {
     println(trap(Array(0,1,0,2,1,0,1,3,2,1,2,1)))
   }


   def trap(height: Array[Int]): Int = {
     val l = height.length
     var leftMax = 0
     var  rightMax = 0
     var left = 0
     var right = l-1

     var ans = 0
     while (left < right){
       breakable{
         leftMax = math.max(height(left), leftMax)
         rightMax = math.max(height(right), rightMax)
         // 这里有隐含条件，如果说右面的指针不移动（rightMax没变），左面的指针移动了，有两种情况，当前左数是否小于当前右数（隐含rightMax），
         // 是的话，直接使用最大左数-当前左数即为当前节点可存数据
         // 否则 保持当前左数不变，将右指针指向right-1，求右节点可以放多少水
         if (height(left) < height(right)) {
           ans += (leftMax - height(left))
           left += 1
           break
         }

         if (height(left) >= height(right)) {
           ans += (rightMax - height(right))
           right -= 1
         }
       }

     }
     ans
   }

 }
