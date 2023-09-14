package 数组


/**
 * leetcode 238
 *
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 * 假设要求 answer[i] 则需要先求出 0 至 (i-1)  与 （i+1）至 结尾 的乘积
 *
 * 设两个数组分别表示 位置i左边数据的乘积与位置i右边数据的乘积
 * answerleft[i] = answerleft[i-1]*nums[i-1]
 * answerleft[0]=1
 * answerright[i] = answerright[i+1]*nums[i+1]
 * answerleft[end]=1
 * answer[i] = answerleft[i] * answerright[i]
 *
 *
 * 空间复杂度O(1)的解法
 * 将answer数组作为 answerleft 使用
 * 从最右边遍历answer ，维护一个变量R，用来记录从最右边到当前位置的乘积，
 * 每向前移动一个位置 R=R*nums[i],answer[i] = answer[i]*R
 *
 *
 *
 *
 */
object 除自身以外数组的乘积 {

}
