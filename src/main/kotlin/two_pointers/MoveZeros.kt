package org.example.two_pointers

/*
283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
* */

fun main() {
    val nums = intArrayOf(0,1,0,3,12)
    moveZeroes(nums)
}

fun moveZeroes(nums: IntArray): Unit {
    var count = 0
    var index = 0

    for (n in nums) {
        if (n == 0) {
            count++
        } else {
            nums[index++] = n
        }
    }

    while (count > 0) {
        nums[nums.size - count--] = 0
    }

    println(nums.joinToString(","))
}