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
