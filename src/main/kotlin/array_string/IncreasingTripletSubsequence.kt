package org.example.array_string

/* 334. Increasing Triplet Subsequence
Given an integer array nums, return true if there exists a triple of indices (i, j, k)
such that i < j < k and nums[i] < nums[j] < nums[k].
If no such indices exists, return false.

Example 1:
Input: nums = [1,2,3,4,5]
Output: true

Example 2:
Input: nums = [5,4,3,2,1]
Output: false

Input: nums = [2,1,5,0,4,6]
Output: true
*/

fun main() {
    val nums1 = intArrayOf(1,2,3,4,5)
    val nums2 = intArrayOf(5,4,3,2,1)
    val nums3 = intArrayOf(2,1,5,0,4,6)

    println(increasingTriplet(nums1))
    println(increasingTriplet(nums2))
    println(increasingTriplet(nums3))
}

fun increasingTriplet(nums: IntArray): Boolean {
    if (nums.size < 3)
        return false

    var a = Integer.MAX_VALUE
    var b = Integer.MAX_VALUE

    for (num in nums) {
        if (num <= a) {
            a = num
        } else if (num <= b) {
            b = num
        } else {
            return true
        }
    }
    return false
}